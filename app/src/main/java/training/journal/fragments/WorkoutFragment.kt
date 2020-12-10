package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_workout.*
import training.journal.R
import training.journal.items.WorkoutItem
import training.journal.utils.recycler.adapters.BaseListAdapter
import training.journal.viewholders.WorkoutElementViewHolder

class WorkoutFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        addExerciseButton = add_exercise_button

        val elements = Observable.just(listOf(
                WorkoutItem("id1", R.drawable.ic_account_circle_black_24dp, "Title 1", "Sample description 1"),
                WorkoutItem("id2", R.drawable.ic_account_circle_black_24dp, "Title 2", "Sample description 2"),
                WorkoutItem("id3", R.drawable.ic_account_circle_black_24dp, "Title 3", "Sample description 3"),
                WorkoutItem("id4", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id5", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id6", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id7", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id8", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id9", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id10", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id11", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id12", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id13", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id14", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id15", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id16", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id17", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id18", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id19", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                WorkoutItem("id20", R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4")
        ))

        val workoutElementAdapter = BaseListAdapter(
                holderType = WorkoutElementViewHolder::class,
                layoutId = R.layout.item_workout_element,
                dataSource = elements,
                onClick = {
                    TODO("Write logic here")
                }
        )

        recyclerView?.adapter = workoutElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout
}
