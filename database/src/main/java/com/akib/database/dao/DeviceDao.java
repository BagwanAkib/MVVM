package com.akib.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.akib.database.entity.Device;

import java.util.List;


@Dao
public interface DeviceDao {

    @Insert
    long insert(Device object);

    @Insert
    void insertAll(List<Device> object);

    @Update
    void update(Device object);

    @Query("Select * from Device where StringValue not like '%:%'")
    LiveData<List<Device>> getAll();

    @Query("delete from Device")
    void deleteAll();
}
