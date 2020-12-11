package training.journal.items

import training.journal.items.interfaces.WithId

data class Parameter(
    override val id: String,
    val title: String,
    val value: Int,
    val unitId: Long, // TODO: WHF are indexes???
    val inputTypeId: Long
) : WithId
