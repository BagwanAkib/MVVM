package com.akib.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Device {
    @PrimaryKey(autoGenerate = true)
    int id;
    //onConflict = OnConflictStrategy. REPLACE

    @ColumnInfo(name = "key")
    String key;

    @ColumnInfo(name = "StringValue")
    String StringValue;

    @ColumnInfo(name = "LongValue")
    long LongValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStringValue() {
        return StringValue;
    }

    public void setStringValue(String stringValue) {
        StringValue = stringValue;
    }

    public long getLongValue() {
        return LongValue;
    }

    public void setLongValue(long longValue) {
        LongValue = longValue;
    }
}
