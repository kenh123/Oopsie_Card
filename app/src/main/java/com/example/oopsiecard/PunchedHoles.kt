package com.example.oopsiecard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "punchedHoles")
class PunchedHoles(@field:PrimaryKey(autoGenerate = false) var holeId: Int, var resourceId: Int)