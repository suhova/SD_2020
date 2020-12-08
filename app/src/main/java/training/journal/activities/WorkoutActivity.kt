package training.journal.activities

import androidx.fragment.app.Fragment
import training.journal.fragments.ExerciseFragment
import training.journal.fragments.WorkoutFragment
import training.journal.utils.ExerciseListener

class WorkoutActivity : BaseNoAppbarActivity(), ExerciseListener {

    override fun getSupportingFragment(): Fragment = WorkoutFragment()

    override fun onExerciseAdding() {
        setFragment(ExerciseFragment())
    }

    override fun onExerciseClicked(exerciseIndex: Int) {
        setFragment(ExerciseFragment())
    }

    override fun onExerciseSaved(exerciseIndex: Int) {
        setFragment(WorkoutFragment())
    }

    override fun onExerciseCanceled(exerciseIndex: Int) {
        setFragment(WorkoutFragment())
    }
}
