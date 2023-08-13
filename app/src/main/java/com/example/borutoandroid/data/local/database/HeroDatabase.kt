package com.example.borutoandroid.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.borutoandroid.data.local.dao.HeroDao
import com.example.borutoandroid.domain.model.Hero
import com.example.borutoandroid.data.local.dao.HeroRemoteKeyDao
import com.example.borutoandroid.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1, exportSchema = false)
abstract class HeroDatabase : RoomDatabase() {

    //get hero dao
    abstract fun getHeroDao() : HeroDao

    //get hero remote key dao
    abstract fun getHeroRemoteKeyDao() : HeroRemoteKeyDao

}