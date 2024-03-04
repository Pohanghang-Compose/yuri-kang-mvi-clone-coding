package org.sopt.mvi_clone_coding.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonDetails(
    // PokemonDetails가 PokemonEntity 필드 포함 중
    @Embedded
    val pokemon: PokemonEntity,

    // 다른 엔티티와의 관계 정의
    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = MultiplierEntity::class)
    val multipliers: List<MultiplierEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = NextEvolutionEntity::class)
    val nextEvolutions: List<NextEvolutionEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = PrevEvolutionEntity::class)
    val prevEvolutions: List<PrevEvolutionEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = TypeEntity::class)
    val types: List<TypeEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = WeaknessEntity::class)
    val weaknesses: List<WeaknessEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = ImageEntity::class)
    val image: ImageEntity,
)
