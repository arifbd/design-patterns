package xyz.arifz.designpatterns.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterListNetworkResponse(
    @SerializedName("info")
    @Expose
    var info: InfoNetworkEntity,

    @SerializedName("results")
    @Expose
    var results: List<CharacterNetworkEntity>
)


data class InfoNetworkEntity(
    @SerializedName("count")
    @Expose
    var count: Int,

    @SerializedName("next")
    @Expose
    var next: String,

    @SerializedName("pages")
    @Expose
    var pages: Int,

    @SerializedName("prev")
    @Expose
    var prev: Any
)


data class CharacterNetworkEntity(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("created")
    @Expose
    var created: String,

    @SerializedName("gender")
    @Expose
    var gender: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("species")
    @Expose
    var species: String,

    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("type")
    @Expose
    var type: String,

    @SerializedName("url")
    @Expose
    var url: String
)