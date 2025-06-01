package com.example.proyecto1.Data.Model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto1.Data.Model.model.AccountEntity
import com.example.proyecto1.Data.Model.dao.AccountDao

@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}