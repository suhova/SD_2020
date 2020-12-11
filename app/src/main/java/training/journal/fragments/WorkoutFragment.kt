package training.journal.fragments

import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import training.journal.R
import training.journal.db.entity.ExerciseEntity
import training.journal.db.entity.WorkoutEntity
import training.journal.db.entity.WorkoutExerciseEntity
import training.journal.items.ItemsList
import training.journal.lifecycle.Page.Companion.WORKOUT_ID_KEY
import training.journal.utils.logger.Logger
import training.journal.utils.recycler.adapters.ExerciseListAdapter
import training.journal.viewholders.ExerciseViewHolder

class WorkoutFragment : BaseFragment() {

    private var workoutNameEditText: EditText? = null
    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: ImageView? = null
    private var workout: WorkoutEntity? = null
    private var chooseTimeButton: Button? = null
    private var weekdayCheckboxes: Array<CheckBox>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workoutNameEditText = workout_name
        recyclerView = elements_list
        addExerciseButton = add_exercise_button
        chooseTimeButton = choose_workout_time
        weekdayCheckboxes = arrayOf(day1, day2, day3, day4, day5, day6, day7)

        GlobalScope.launch(Dispatchers.IO) {
            val workoutId = (activity?.intent?.extras?.get(WORKOUT_ID_KEY)) as Long
            val exerciseList = database?.workoutExerciseDao()?.getExercisesForWorkout(workoutId)!!
            workout = database?.workoutDao()?.getById(workoutId)

            withContext(Dispatchers.Main) {
                workoutNameEditText?.setText(workout?.name)
                val elements = ItemsList(exerciseList)

                val exerciseAdapter = ExerciseListAdapter(
                    holderType = ExerciseViewHolder::class,
                    layoutId = R.layout.item_workout_element,
                    dataSource = elements,
                    onClick = {
                        router?.showExercisePage(it.id)
                    },
                    onDeleteExerciseClick = {
                        GlobalScope.launch(Dispatchers.IO) {
                            database?.exerciseDao()?.delete(it)
                            withContext(Dispatchers.Main) {
                                elements.remove(it)
                            }
                        }
                    }
                )

                recyclerView?.adapter = exerciseAdapter
                recyclerView?.layoutManager = LinearLayoutManager(activity)
                recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

                addExerciseButton?.setOnClickListener {
                    GlobalScope.launch(Dispatchers.IO) {
                        val exerciseEntity = ExerciseEntity("", "", 1)
                        exerciseEntity.id = database?.exerciseDao()?.insert(exerciseEntity)!!
                        database?.workoutExerciseDao()?.insert(WorkoutExerciseEntity(
                            workoutId,
                            exerciseEntity.id
                        ))
                        withContext(Dispatchers.Main) {
                            elements.add(
                                exerciseEntity
                            )
                            router?.showExercisePage(exerciseEntity.id)
                        }
                    }
                }
                workoutNameEditText!!.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        if (s != null && s.isNotEmpty()) {
                            workoutNameEditText!!.setBackgroundColor(Color.WHITE)
                        }
                    }
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                })
                chooseTimeButton?.text = workout!!.plannedTime
                chooseTimeButton?.setOnClickListener {
                    TimePickerDialog(
                        it.context,
                        TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                            run {
                                val timeStr = if (minute < 10) "$hourOfDay:0$minute" else "$hourOfDay:$minute"
                                chooseTimeButton?.text = timeStr
                            }
                        },
                        12, 0, true
                    ).show()
                }
                for (i in weekdayCheckboxes!!.indices) {
                    val bit = 1 shl i
                    val checkBox = weekdayCheckboxes!![i]
                    if (bit and workout!!.weekdaysMask != 0) {
                        checkBox.isChecked = true
                    }
                    checkBox.setOnCheckedChangeListener { v, checked ->
                        if (checked) {
                            for (ii in weekdayCheckboxes!!.indices) {
                                weekdayCheckboxes!![ii].setBackgroundColor(Color.WHITE)
                            }
                        }
                    }
                }
            }
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Logger.d(this, "onCreateOptionsMenu")
        inflater.inflate(R.menu.apply_reject_menu, menu)
        val saveButton: MenuItem = menu.findItem(R.id.apply_changes)
        saveButton.setOnMenuItemClickListener {

            val workoutTime = chooseTimeButton?.text.toString()
            var weekdaysMask = 0
            for (i in weekdayCheckboxes!!.indices) {
                if (weekdayCheckboxes!![i].isChecked) {
                    weekdaysMask = weekdaysMask or (1 shl i)
                }
            }

            val workoutName = workoutNameEditText?.text.toString()
            when {
                workoutName == "" -> {
                    workoutNameEditText?.setBackgroundColor(Color.RED)
                }
                weekdaysMask == 0 -> {
                    weekdayCheckboxes?.forEach {
                        it.setBackgroundColor(Color.RED)
                    }
                }
                else -> {
                    GlobalScope.launch(Dispatchers.IO) {
                        workout?.name = workoutName
                        workout?.plannedTime = workoutTime
                        workout?.weekdaysMask = weekdaysMask
                        database?.workoutDao()?.update(workout!!)
                        withContext(Dispatchers.Main) {
                            router?.goToPrevFragment()
                        }
                    }
                }
            }
            true
        }
        val cancelButton: MenuItem = menu.findItem(R.id.reject_changes)
        cancelButton.setOnMenuItemClickListener {
            val workoutName = workoutNameEditText?.text.toString()
            GlobalScope.launch(Dispatchers.IO) {
                if (workoutName == "") {
                        database?.workoutDao()?.delete(workout!!)
                }
                withContext(Dispatchers.Main) {
                    router?.goToPrevFragment()
                }
            }

            true
        }
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout
}
