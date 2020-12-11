package training.journal.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import training.journal.db.entity.WorkoutEntity

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM WorkoutEntity")
    fun getAll(): MutableList<WorkoutEntity>

    @Query("SELECT * FROM WorkoutEntity WHERE id = :id")
    fun getById(id: Long): WorkoutEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workoutEntity: WorkoutEntity): Long

    @Insert
    fun insert(workoutEntityList: List<WorkoutEntity>): List<Long>

    @Update
    fun update(workoutEntity: WorkoutEntity): Int

    @Update
    fun update(workoutEntityList: List<WorkoutEntity>): Int

    @Delete
    fun delete(workoutEntity: WorkoutEntity): Int
}