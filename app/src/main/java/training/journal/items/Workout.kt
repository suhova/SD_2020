package training.journal.items

import training.journal.items.interfaces.WithId

data class Workout(
    override val id: String,
    val time: String,
    val title: String
) : WithId
