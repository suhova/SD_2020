package training.journal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParameterTypeEntity(
    @ColumnInfo var name: String,
    @ColumnInfo var serverId: Long = -1,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
) {
    override fun toString(): String {
        return name
    }
}
