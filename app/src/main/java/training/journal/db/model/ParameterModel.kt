package training.journal.db.model

import training.journal.db.entity.MeasureUnitEntity
import training.journal.db.entity.ParameterEntity
import training.journal.db.entity.ParameterTypeEntity

data class ParameterModel(
    var parameter: ParameterEntity,
    var measureUnitChoices: MutableList<MeasureUnitEntity>,
    var parameterTypeChoices: MutableList<ParameterTypeEntity>
)
