package com.example.oopsiecard

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface PunchedHolesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(punchedHoles: PunchedHoles?)

    @Update
    fun update(punchedHoles: PunchedHoles?)

    @Delete
    fun delete(punchedHoles: PunchedHoles?)

    @Query("SELECT resourceId FROM PunchedHoles ORDER BY holeId ASC")
    fun allHoles():List<Int>
}