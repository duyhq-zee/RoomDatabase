package com.duyhq.roomdatabase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private PersonRepository mPersonRepository;
    private LiveData<List<Person>> mPersonList;

    public PersonViewModel(Application application) {
        super(application);
        mPersonRepository = new PersonRepository(application);
        mPersonList = mPersonRepository.getAll();
    }

    public LiveData<List<Person>> getAll() {
        return mPersonList;
    }

    public void insert(Person person) {
        mPersonRepository.insert(person);
    }
}
