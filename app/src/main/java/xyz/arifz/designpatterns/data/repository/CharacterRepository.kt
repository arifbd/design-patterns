package xyz.arifz.designpatterns.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import xyz.arifz.designpatterns.data.local.CharacterCacheMapper
import xyz.arifz.designpatterns.data.local.CharacterDao
import xyz.arifz.designpatterns.data.model.Character
import xyz.arifz.designpatterns.data.remote.CharacterNetworkMapper
import xyz.arifz.designpatterns.data.remote.CharacterService
import xyz.arifz.designpatterns.util.DataState

class CharacterRepository constructor(
    private val characterDao: CharacterDao,
    private val characterCacheMapper: CharacterCacheMapper,
    private val characterService: CharacterService,
    private val characterNetworkMapper: CharacterNetworkMapper
) {
    suspend fun getCharacters(): Flow<DataState<List<Character>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkCharacterResponse = characterService.getCharacters()
            val networkCharacters = networkCharacterResponse.results
            val characters = characterNetworkMapper.mapFromEntityList(networkCharacters)
            for (character in characters)
                characterDao.insert(characterCacheMapper.mapToEntity(character))
            val cachedCharacters = characterDao.get()
            emit(DataState.Success(characterCacheMapper.mapFromEntityList(cachedCharacters)))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }
}