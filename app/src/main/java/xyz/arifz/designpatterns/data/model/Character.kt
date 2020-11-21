package xyz.arifz.designpatterns.data.model

import com.google.gson.GsonBuilder
import java.io.Serializable

data class Character(
    var id: Int,
    var created: String,
    var gender: String,
    var image: String,
    var name: String,
    var species: String,
    var status: String,
    var type: String,
    var url: String
) : Serializable {
    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}