package com.example.gainnote.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gainnote.model.TrainingSession;
import com.example.gainnote.model.User;

import java.util.List;

@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TrainingSession training_session);

    @Query("UPDATE user SET firstname = :firstname WHERE id=:id")
    void updateFirstname(String firstname, int id);
    @Query("UPDATE user SET name = :name WHERE id=:id")
    void updateName(String name, int id);
    @Query("UPDATE user SET height = :height WHERE id=:id")
    void updateHeight(int height, int id);
    @Query("UPDATE user SET firstname = :bodyType WHERE id=:id")
    void updateBodyType(String bodyType, int id);
    @Query("UPDATE user SET sexe = :sexe WHERE id=:id")
    void updateSexe(String sexe, int id);
    @Query("DELETE FROM user")
    void deleteAllData();
    @Query("SELECT * FROM User WHERE id=:id")
    User getUserById(int id);
    @Query("SELECT * FROM User LIMIT 1")
    User getUser();
    @Query("SELECT * FROM User")
    List<User> getAllUsers();
    @Delete
    void delete(User user);


    @Query("SELECT * FROM TrainingSession ORDER BY date, time DESC")
    List<TrainingSession> getAllTrainingSession();
    @Query("DELETE FROM trainingsession")
    void deleteAllSessions();
}
