package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.date.dayOfMonth
import com.afollestad.date.month
import com.afollestad.date.year
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import training.journal.R
import training.journal.db.entity.UserWorkoutEntity
import training.journal.db.entity.WorkoutEntity
import training.journal.items.ItemsList
import training.journal.repository.CurrentUserRepository
import training.journal.utils.recycler.adapters.CalendarWorkoutListAdapter
import training.journal.viewholders.WorkoutViewHolder
import java.util.Calendar

class CalendarFragment : BaseFragment() {

    private var addWorkoutButton: ImageView? = null
    private var recyclerView: RecyclerView? = null
    private var userId: Long? = null

    private var calendar: CalendarView? = null
    private val systemCalendar = Calendar.getInstance()

    private var workoutList: MutableList<WorkoutEntity>? = null
    private var elements: ItemsList<WorkoutEntity>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar = view.calendar

        addWorkoutButton = view.add_workout_button
        recyclerView = view.workout_list

        GlobalScope.launch(Dispatchers.IO) {
            val email = CurrentUserRepository.currentUser.value!!.email
            val user = database!!.userDao().getByEmail(email)
            userId = user.id
            workoutList = database!!.userWorkoutDao().getWorkoutsForUser(userId!!)

            withContext(Dispatchers.Main) {
                val filteredList = filterWorkouts(
                    systemCalendar.year,
                    systemCalendar.month,
                    systemCalendar.dayOfMonth
                )
                elements = ItemsList(filteredList)

                val workoutAdapter = CalendarWorkoutListAdapter(
                    holderType = WorkoutViewHolder::class,
                    layoutId = R.layout.item_workout,
                    dataSource = elements!!,
                    onClick = {
                        router?.showWorkoutPage(it.id)
                    },
                    onStartWorkoutClick = {
                        router?.showActiveExercisePage()
                    },
                    onDeleteWorkoutClick = {
                        GlobalScope.launch(Dispatchers.IO) {
                            database?.workoutDao()?.delete(it)
                            withContext(Dispatchers.Main) {
                                workoutList!!.remove(it)
                                elements!!.remove(it)
                            }
                        }
                    }
                )

                recyclerView?.adapter = workoutAdapter
                recyclerView?.layoutManager = LinearLayoutManager(activity)
                recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

                addWorkoutButton?.setOnClickListener {
                    GlobalScope.launch(Dispatchers.IO) {
                        val workoutEntity = WorkoutEntity("", "12:00", 0, "")
                        workoutEntity.id = database?.workoutDao()?.insert(workoutEntity)!!

                        val userWorkoutEntity = UserWorkoutEntity(
                            userId!!,
                            workoutEntity.id,
                            ""
                        )
                        database!!.userWorkoutDao().insert(userWorkoutEntity)
                        withContext(Dispatchers.Main) {
                            elements!!.add(
                                workoutEntity
                            )
                            router?.showWorkoutPage(workoutEntity.id)
                        }
                    }
                }

                calendar?.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    val filtered = filterWorkouts(year, month, dayOfMonth)
                    println(filtered.size)
                    elements!!.setData(filtered)
                }
            }
        }
    }

    override fun onResume() {
        if (elements != null) {
            val filteredList = filterWorkouts(
                systemCalendar.year,
                systemCalendar.month,
                systemCalendar.dayOfMonth
            )
            elements!!.setData(filteredList)
        }
        super.onResume()
    }

    private fun filterWorkouts(year: Int, month: Int, dayOfMonth: Int): MutableList<WorkoutEntity> {
        val tmpYear = systemCalendar.year
        val tmpMonth = systemCalendar.month
        val tmpDay = systemCalendar.dayOfMonth
        systemCalendar.set(year, month, dayOfMonth)
        val dayOfWeekIndex: Int = (systemCalendar.get(Calendar.DAY_OF_WEEK) - 1 + 6) % 7
        println("filter: $dayOfWeekIndex")
        systemCalendar.set(tmpYear, tmpMonth, tmpDay)
        return workoutList!!.filter {
            println("" + (1 shl dayOfWeekIndex) + " | " + it.weekdaysMask)
            ((1 shl dayOfWeekIndex) and it.weekdaysMask) != 0
        }.toMutableList()
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_calendar
}
