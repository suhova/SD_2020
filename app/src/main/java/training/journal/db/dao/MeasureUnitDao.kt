package training.journal.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import training.journal.db.entity.MeasureUnitEntity

@Dao
interface MeasureUnitDao {
    @Query("SELECT * FROM MeasureUnitEntity")
    fun getAll(): List<MeasureUnitEntity>

    @Query("SELECT * FROM MeasureUnitEntity WHERE id = :id")
    fun getById(id: Long): MeasureUnitEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(measureUnitEntity: MeasureUnitEntity): Long

    @Insert
    fun insert(measureUnitEntityList: List<MeasureUnitEntity>): List<Long>

    @Update
    fun update(measureUnitEntity: MeasureUnitEntity): Int

    @Update
    fun update(measureUnitEntityList: List<MeasureUnitEntity>): Int

    @Delete
    fun delete(measureUnitEntity: MeasureUnitEntity): Int
}