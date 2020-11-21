package xyz.arifz.designpatterns.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import xyz.arifz.designpatterns.data.local.CharacterDao
import xyz.arifz.designpatterns.data.local.MyRoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MyRoomDatabase {
        return Room.databaseBuilder(context, MyRoomDatabase::class.java, MyRoomDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCharacterDAO(database: MyRoomDatabase): CharacterDao = database.characterDao()

}