package xyz.arifz.designpatterns.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.arifz.designpatterns.data.remote.CharacterService
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService = retrofit.create(CharacterService::class.java)

}