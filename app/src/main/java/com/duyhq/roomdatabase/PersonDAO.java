package com.duyhq.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDAO {
    @Query("SELECT * FROM Person")
    LiveData<List<Person>> getAll();

    @Query("SELECT * FROM Person WHERE id = :id")
    Person findPersonById(int id);

    @Insert
    void insert(Person person);

    @Update
    void update(Person person);

    @Delete
    void delete(Person person);
}
