package xyz.arifz.designpatterns.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import xyz.arifz.designpatterns.data.local.CharacterCacheMapper
import xyz.arifz.designpatterns.data.local.CharacterDao
import xyz.arifz.designpatterns.data.remote.CharacterNetworkMapper
import xyz.arifz.designpatterns.data.remote.CharacterService
import xyz.arifz.designpatterns.data.repository.CharacterRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(
        characterDao: CharacterDao,
        characterService: CharacterService,
        characterCacheMapper: CharacterCacheMapper,
        characterNetworkMapper: CharacterNetworkMapper
    ): CharacterRepository = CharacterRepository(
        characterDao,
        characterCacheMapper,
        characterService,
        characterNetworkMapper
    )

}