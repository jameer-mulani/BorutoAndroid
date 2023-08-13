package com.example.borutoandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.borutoandroid.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    //add single hero remote key
    @Query("SELECT * FROM hero_remote_key_table WHERE id = :id")
    suspend fun addHeroRemoteKey(id : Int)

    //insert all hero remote keys
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroRemoteKeys(keys : List<HeroRemoteKey>)

    //delete all hero remote keys
    @Query("DELETE FROM hero_remote_key_table")
    suspend fun deleteAllHeroRemoteKeys()

}