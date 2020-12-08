package training.journal.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_workout.*
import training.journal.R
import training.journal.utils.*
import training.journal.utils.recycler.adapters.WorkoutElementAdapter
import training.journal.utils.recycler.elements.WorkoutElement

class WorkoutFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var addExerciseButton: ImageButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = elements_list
        addExerciseButton = add_exercise_button

        addExerciseButton?.setOnClickListener { (activity as? ExerciseListener)?.onExerciseAdding() }

        val workoutElementAdapter = WorkoutElementAdapter(ArrayList(
                mutableListOf(
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 1", "Sample description 1"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 2", "Sample description 2"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 3", "Sample description 3"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 4", "Sample description 4"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 5", "Sample description 5"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 6", "Sample description 6"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 7", "Sample description 7"),
                        WorkoutElement(R.drawable.ic_account_circle_black_24dp, "Title 8", "Sample description 8")
                )
        )
        ) {
            val exerciseId = it?.let { v -> recyclerView?.getChildLayoutPosition(v) }
            if (exerciseId != null && exerciseId != -1) {
                (activity as? ExerciseListener)?.onExerciseClicked(exerciseId)
            }
        }

        recyclerView?.adapter = workoutElementAdapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_workout

}
