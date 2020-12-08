package training.journal.utils

interface ExerciseListener {
    fun onExerciseAdding()
    fun onExerciseClicked(exerciseIndex: Int)
    fun onExerciseSaved(exerciseIndex: Int)
    fun onExerciseCanceled(exerciseIndex: Int)
}
