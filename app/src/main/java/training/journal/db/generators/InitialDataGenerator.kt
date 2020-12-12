package training.journal.db.generators

import training.journal.db.entity.ExerciseEntity
import training.journal.db.entity.ExerciseTypeEntity
import training.journal.db.entity.MeasureUnitEntity
import training.journal.db.entity.ParameterEntity
import training.journal.db.entity.ParameterTypeEntity

// TODO: load initial data from the server with current app locale
class InitialDataGenerator {
    companion object {
        fun getParameterTypes(): List<ParameterTypeEntity> {
            return listOf(
                    ParameterTypeEntity("Цель", true),
                    ParameterTypeEntity("Результат", false)
            )
        }
        fun getExerciseTypes(): List<ExerciseTypeEntity> {
            return listOf(
                    ExerciseTypeEntity("Силовое"),
                    ExerciseTypeEntity("Кардио"),
                    ExerciseTypeEntity("Координация"),
                    ExerciseTypeEntity("Опорно-двигательное")
            )
        }
        fun getMeasureUnits(): List<MeasureUnitEntity> {
            return listOf(
                    MeasureUnitEntity("Миллиметры", "мм"),
                    MeasureUnitEntity("Сантиметры", "см"),
                    MeasureUnitEntity("Метры", "м"),
                    MeasureUnitEntity("Километры", "км"),
                    MeasureUnitEntity("Единицы", "ед"),
                    MeasureUnitEntity("Секунды", "сек"),
                    MeasureUnitEntity("Минуты", "мин"),
                    MeasureUnitEntity("Часы", "ч"),
                    MeasureUnitEntity("Килограммы", "кг")
            )
        }
        fun getParameters(): List<ParameterEntity> {
            return listOf(
                    ParameterEntity("Время (цель)", 6, 1),
                    ParameterEntity("Время (результат)", 6, 2),
                    ParameterEntity("Дистанция (цель)", 3, 1),
                    ParameterEntity("Дистанция (результат)", 3, 2),
                    ParameterEntity("Повторения (цель)", 5, 1),
                    ParameterEntity("Повторения (результат)", 5, 2),
                    ParameterEntity("Вес (цель)", 9, 1),
                    ParameterEntity("Вес (результат)", 9, 2)
            )
        }
    }
}