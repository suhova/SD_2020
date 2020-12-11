package training.journal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @ColumnInfo var firstName: String,
    @ColumnInfo var lastName: String?,
    @ColumnInfo var fatherName: String?,
    @ColumnInfo var email: String,
    @ColumnInfo var gender: String,
    @ColumnInfo var avatarUrl: String?,
    @ColumnInfo var serverId: Long = -1,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)
