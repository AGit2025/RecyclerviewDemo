package com.example.sampleapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sampleapplication.model.User

@Dao

interface UserDaoktln {

        @Insert
        suspend fun insertPerson(user : User)

        @Update
        suspend fun updatePerson(user : User)

//        @Query(selecr * from  users)
//        fun getAllusers() : LiveData<List<User>>
    }
