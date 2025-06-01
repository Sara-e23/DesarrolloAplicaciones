package com.example.proyecto1.Data.Model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyecto1.Data.Model.model.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
    fun getAll(): List<AccountEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: AccountEntity)

    @Delete
    fun delete(account: AccountEntity)
}