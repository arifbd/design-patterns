package xyz.arifz.designpatterns.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterCacheEntity): Long

    @Query("SELECT * FROM table_characters")
    suspend fun get(): List<CharacterCacheEntity>

}