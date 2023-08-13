package com.example.borutoandroid.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.borutoandroid.data.local.dao.HeroDao
import com.example.borutoandroid.domain.model.Hero

@Database(entities = [Hero::class], version = 1, exportSchema = false)
abstract class HeroDatabase : RoomDatabase() {

    //get hero dao
    abstract fun getHeroDao() : HeroDao

}