package com.mksoft.memoalarmapp.DB;


import com.mksoft.memoalarmapp.DB.data.MemoData;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MemoData.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract MemoDataDao memoDataDao();
    private static volatile AppDB INSTANCE;//volatile 메모리에 접근 가능

}
