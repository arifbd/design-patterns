package xyz.arifz.designpatterns.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_characters")
data class CharacterCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "created")
    var created: String,

    @ColumnInfo(name = "gender")
    var gender: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "species")
    var species: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "url")
    var url: String
)