package training.journal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MeasureUnitEntity::class,
            parentColumns = ["id"],
            childColumns = ["measureUnitId"]
        ),
        ForeignKey(
            entity = ParameterTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["parameterTypeId"]
        )
    ]
)
data class ParameterEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var measureUnitId: Long,
    @ColumnInfo var parameterTypeId: Long,
    @ColumnInfo var value: Float = 0.0f,
    @ColumnInfo var serverId: Long = -1,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)
