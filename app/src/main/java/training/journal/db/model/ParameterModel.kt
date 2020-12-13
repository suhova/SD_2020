package training.journal.db.model

import training.journal.db.entity.MeasureUnitEntity
import training.journal.db.entity.ParameterEntity

data class ParameterModel(
    var parameter: ParameterEntity,
    var measureUnitChoices: MutableList<MeasureUnitEntity>
)
