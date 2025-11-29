package com.example.bitfit

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workouts ORDER BY id DESC")
    fun getAll(): Flow<List<WorkoutEntity>>

    @Insert
    fun insert(workout: WorkoutEntity): Long

    @Update
    fun update(workout: WorkoutEntity): Int

    @Delete
    fun delete(workout: WorkoutEntity): Int
}