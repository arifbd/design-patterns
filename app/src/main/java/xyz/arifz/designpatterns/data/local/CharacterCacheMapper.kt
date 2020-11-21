package xyz.arifz.designpatterns.data.local

import xyz.arifz.designpatterns.data.model.Character
import xyz.arifz.designpatterns.util.EntityMapper
import javax.inject.Inject

class CharacterCacheMapper @Inject constructor() : EntityMapper<CharacterCacheEntity, Character> {
    override fun mapFromEntity(entity: CharacterCacheEntity): Character {
        return Character(
            id = entity.id,
            created = entity.created,
            gender = entity.gender,
            image = entity.image,
            name = entity.name,
            species = entity.species,
            status = entity.status,
            type = entity.type,
            url = entity.url,
        )
    }

    override fun mapToEntity(domainModel: Character): CharacterCacheEntity {
        return CharacterCacheEntity(
            id = domainModel.id,
            created = domainModel.created,
            gender = domainModel.gender,
            image = domainModel.image,
            name = domainModel.name,
            species = domainModel.species,
            status = domainModel.status,
            type = domainModel.type,
            url = domainModel.url,
        )
    }

    fun mapFromEntityList(entities: List<CharacterCacheEntity>): List<Character> {
        return entities.map { mapFromEntity(it) }
    }
}