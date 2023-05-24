package com.example.oopsiecard

import android.app.Application
import com.example.oopsiecard.DatabaseBuilder.Companion.getDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository(application: Application) {
    private val mPunchedHolesDAO: PunchedHolesDAO
    private val mPunchedHoles: PunchedHoles? = null

    var allPunchedHoles: List<Int>? = null
    private val NUMBER_OF_THREADS = 4
    private val databaseExecutor: ExecutorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

    init {
        val db = getDatabase(application.applicationContext)!!
        mPunchedHolesDAO = db.punchedHolesDAO()
    }

    fun insert(punchedHoles: PunchedHoles?) {
        databaseExecutor.execute { mPunchedHolesDAO.insert(punchedHoles) }
    }

    fun update(punchedHoles: PunchedHoles?) {
        databaseExecutor.execute { mPunchedHolesDAO.update(punchedHoles) }
    }

    fun delete(punchedHoles: PunchedHoles?) {
        databaseExecutor.execute { mPunchedHolesDAO.delete(punchedHoles) }
    }

    fun allHoles(){
        databaseExecutor.execute {allPunchedHoles = mPunchedHolesDAO.allHoles()}

    }

}