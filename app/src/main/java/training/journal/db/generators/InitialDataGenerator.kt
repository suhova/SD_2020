package training.journal.db.generators

import training.journal.db.entity.ExerciseTypeEntity
import training.journal.db.entity.MeasureUnitEntity
import training.journal.db.entity.ParameterTypeEntity

// TODO: load initial data from the server with current app locale
class InitialDataGenerator {
    companion object {
        fun getParameterTypes(): List<ParameterTypeEntity> {
            return listOf(
                ParameterTypeEntity("Цель"),
                ParameterTypeEntity("Результат"),
                ParameterTypeEntity("Секундомер"),
                ParameterTypeEntity("Таймер")
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
                MeasureUnitEntity("Часы", "ч")
            )
        }
    }
}