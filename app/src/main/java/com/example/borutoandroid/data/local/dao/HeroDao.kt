package com.example.borutoandroid.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.borutoandroid.domain.model.Hero

@Dao
interface HeroDao {

    //get all heroes
    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes() : PagingSource<Int, Hero>

    //get selected hero
    @Query("SELECT * FROM hero_table WHERE id=:heroId")
    fun getSelectedHero(heroId : Int) : Hero

    //delete all heroes
    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()

    //insert all heroes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllHeroes(heroes : List<Hero>)

}