package training.journal.db.model

import androidx.room.Embedded
import androidx.room.Relation
import training.journal.db.entity.UserEntity
import training.journal.db.entity.WorkoutEntity

data class UserWorkoutModel(
    @Embedded
    var user: UserEntity,
    @Relation(parentColumn = "id", entity = WorkoutEntity::class, entityColumn = "userId")
    var workouts: List<WorkoutEntity>
)
