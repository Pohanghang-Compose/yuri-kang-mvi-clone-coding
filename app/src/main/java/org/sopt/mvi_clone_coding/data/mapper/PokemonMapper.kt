package org.sopt.mvi_clone_coding.data.mapper

import org.sopt.mvi_clone_coding.data.dto.PokemonItemDto
import org.sopt.mvi_clone_coding.data.entity.ImageEntity
import org.sopt.mvi_clone_coding.data.entity.MultiplierEntity
import org.sopt.mvi_clone_coding.data.entity.NextEvolutionEntity
import org.sopt.mvi_clone_coding.data.entity.PokemonEntity
import org.sopt.mvi_clone_coding.data.entity.PrevEvolutionEntity
import org.sopt.mvi_clone_coding.data.entity.TypeEntity
import org.sopt.mvi_clone_coding.data.entity.WeaknessEntity

internal fun PokemonItemDto.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = this.id,
        avgSpawns = this.avgSpawns,
        candy = this.candy ?: "",
        candyCount = this.candyCount,
        egg = this.egg ?: "",
        height = this.height ?: "",
        name = this.name ?: "",
        num = this.num ?: "",
        spawnChance = this.spawnChance,
        spawnTime = this.spawnTime ?: "",
        weight = this.weight ?: "",
    )
}

internal fun PokemonItemDto.toMultiplierEntities(): List<MultiplierEntity> {
    return this.multipliers?.map { multiplier ->
        MultiplierEntity(
            id = 0,
            pokemonId = this.id,
            value = multiplier,
        )
    } ?: emptyList()
}

internal fun PokemonItemDto.toNextEvolutionEntities(): List<NextEvolutionEntity> {
    return this.nextEvolutions?.map { nextEvolution ->
        NextEvolutionEntity(
            id = 0,
            pokemonId = this.id,
            name = nextEvolution.name,
            num = nextEvolution.num,
        )
    } ?: emptyList()
}

internal fun PokemonItemDto.toPrevEvolutionEntities(): List<PrevEvolutionEntity> {
    return this.prevEvolutions?.map { prevEvolution ->
        PrevEvolutionEntity(
            id = 0,
            pokemonId = this.id,
            name = prevEvolution.name,
            num = prevEvolution.num,
        )
    } ?: emptyList()
}

internal fun PokemonItemDto.toTypeEntities(): List<TypeEntity> {
    return this.types?.map { type ->
        TypeEntity(
            id = 0,
            pokemonId = this.id,
            value = type,
        )
    } ?: emptyList()
}

internal fun PokemonItemDto.toWeaknessEntities(): List<WeaknessEntity> {
    return this.weaknesses?.map { weakness ->
        WeaknessEntity(
            id = 0,
            pokemonId = this.id,
            value = weakness,
        )
    } ?: emptyList()
}

internal fun PokemonItemDto.toImageEntity(localUrl: String): ImageEntity {
    return ImageEntity(
        id = 0,
        pokemonId = this.id,
        localUrl = localUrl,
    )
}
