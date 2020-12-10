package training.journal.items

import training.journal.items.interfaces.WithId

data class ExerciseItem(
    override val id: String,
    val title: String,
    val value: Int,
    val unitIndex: Int, // TODO: WHF are indexes???
    val inputTypeIndex: Int
) : WithId
