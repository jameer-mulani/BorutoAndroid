package com.example.borutoandroid.di

import android.content.Context
import androidx.room.Room
import com.example.borutoandroid.data.local.dao.HeroDao
import com.example.borutoandroid.data.local.dao.HeroRemoteKeyDao
import com.example.borutoandroid.data.local.database.HeroDatabase
import com.example.borutoandroid.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun getHeroDatabase(@ApplicationContext context: Context): HeroDatabase {
        return Room.databaseBuilder(context, HeroDatabase::class.java, Constants.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun getHeroDao(heroDatabase: HeroDatabase): HeroDao = heroDatabase.getHeroDao()

    @Provides
    @Singleton
    fun getHeroRemoteKeyDao(heroDatabase: HeroDatabase): HeroRemoteKeyDao =
        heroDatabase.getHeroRemoteKeyDao()

}