package xyz.arifz.designpatterns.data.remote

import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacters(): CharacterListNetworkResponse
}