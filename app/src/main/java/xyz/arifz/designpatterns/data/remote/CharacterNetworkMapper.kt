package xyz.arifz.designpatterns.data.remote

import xyz.arifz.designpatterns.data.model.Character
import xyz.arifz.designpatterns.util.EntityMapper
import javax.inject.Inject

class CharacterNetworkMapper @Inject constructor() :
    EntityMapper<CharacterNetworkEntity, Character> {

    override fun mapFromEntity(entity: CharacterNetworkEntity): Character {
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

    override fun mapToEntity(domainModel: Character): CharacterNetworkEntity {
        return CharacterNetworkEntity(
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

    fun mapFromEntityList(entities: List<CharacterNetworkEntity>): List<Character> {
        return entities.map { mapFromEntity(it) }
    }

}