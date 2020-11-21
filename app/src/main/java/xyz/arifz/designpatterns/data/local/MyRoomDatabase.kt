package xyz.arifz.designpatterns.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterCacheEntity::class], version = 1)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {
        const val DB_NAME: String = "db_character"
    }

}