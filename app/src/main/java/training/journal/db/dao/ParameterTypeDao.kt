package training.journal.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import training.journal.db.entity.ParameterTypeEntity

@Dao
interface ParameterTypeDao {
    @Query("SELECT * FROM ParameterTypeEntity")
    fun getAll(): List<ParameterTypeEntity>

    @Query("SELECT * FROM ParameterTypeEntity WHERE id = :id")
    fun getById(id: Long): ParameterTypeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(parameterTypeEntity: ParameterTypeEntity): Long

    @Insert
    fun insert(parameterTypeEntityList: List<ParameterTypeEntity>): List<Long>

    @Update
    fun update(parameterTypeEntity: ParameterTypeEntity): Int

    @Update
    fun update(parameterTypeEntityList: List<ParameterTypeEntity>): Int

    @Delete
    fun delete(parameterTypeEntity: ParameterTypeEntity): Int
}