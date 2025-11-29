package com.example.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercises WHERE workoutId = :workoutId ORDER BY id ASC")
    fun getForWorkout(workoutId: Long): Flow<List<ExerciseEntity>>

    @Insert
    fun insertAll(exercises: List<ExerciseEntity>): List<Long>

    @Insert
    fun insert(exercise: ExerciseEntity): Long

    @Query("DELETE FROM exercises WHERE workoutId = :workoutId")
    fun deleteByWorkoutId(workoutId: Long): Int
}