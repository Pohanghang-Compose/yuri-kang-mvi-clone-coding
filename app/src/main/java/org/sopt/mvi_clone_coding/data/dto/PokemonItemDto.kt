package org.sopt.mvi_clone_coding.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonItemDto(
    @SerialName("avg_spawns")
    val avgSpawns: Double = 0.0,
    @SerialName("candy")
    val candy: String? = null,
    @SerialName("candy_count")
    val candyCount: Int = 0,
    @SerialName("egg")
    val egg: String? = null,
    @SerialName("height")
    val height: String? = null,
    @SerialName("id")
    val id: Int = 0,
    @SerialName("img")
    val img: String? = null,
    @SerialName("multipliers")
    val multipliers: List<Double>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("next_evolution")
    val nextEvolution: List<NextEvolutionDto>? = null,
    @SerialName("num")
    val num: String? = null,
    @SerialName("prev_evolution")
    val prevEvolution: List<PrevEvolutionDto>? = null,
    @SerialName("spawn_chance")
    val spawnChance: Double = 0.0,
    @SerialName("spawn_time")
    val spawnTime: String? = null,
    @SerialName("type")
    val type: List<String>? = null,
    @SerialName("weaknesses")
    val weaknesses: List<String>? = null,
    @SerialName("weight")
    val weight: String? = null
)