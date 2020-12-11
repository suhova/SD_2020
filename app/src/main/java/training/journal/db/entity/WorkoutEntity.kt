package training.journal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var plannedTime: String,
    @ColumnInfo var weekdaysMask: Int,
    @ColumnInfo var description: String?,
    @ColumnInfo var serverId: Long = -1,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)
