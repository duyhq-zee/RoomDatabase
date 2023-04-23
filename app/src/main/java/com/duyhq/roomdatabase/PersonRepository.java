package com.duyhq.roomdatabase;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonRepository {
    PersonDAO mPersonDAO;
    LiveData<List<Person>> mPersonList;

    PersonRepository(Application application) {
        mPersonDAO = AppDatabase.getDatabase(application).personDAO();
        mPersonList = mPersonDAO.getAll();
    }

    LiveData<List<Person>> getAll() {
        return mPersonList;
    }

    void insert(Person person) {
        AppDatabase.dbExecutor.execute(() -> mPersonDAO.insert(person));
    }
}
