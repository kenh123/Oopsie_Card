package com.example.oopsiecard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PunchedHoles")
class PunchedHoles(@field:PrimaryKey(autoGenerate = true) var holeId: Int, var resourceId: Int)