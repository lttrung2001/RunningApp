package com.androiddevs.runningappyt.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table SORT ORDER BY timestamp DESC")
    fun getAllRunSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table SORT ORDER BY timeInMillis DESC")
    fun getAllRunSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table SORT ORDER BY caloriesBurned DESC")
    fun getAllRunSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table SORT ORDER BY avgSpeedInKMH DESC")
    fun getAllRunSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table SORT ORDER BY distanceInMeters DESC")
    fun getAllRunSortedByDistanceInMeters(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistanceInMeters(): LiveData<Int>

    @Query("SELECT SUM(avgSpeedInKMH) FROM running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}