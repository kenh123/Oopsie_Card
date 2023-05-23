package com.example.oopsiecard;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private PunchedHolesDAO mPunchedHolesDAO;
    private PunchedHoles mPunchedHoles;
    private List<PunchedHoles> allPunchedHoles;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        DatabaseBuilder db = DatabaseBuilder.getDatabase(application.getApplicationContext());

        assert db != null;
        mPunchedHolesDAO = db.punchedHolesDAO();
    }




}
