package org.sopt.mvi_clone_coding.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Singleton

@Singleton

@Entity(
    tableName = "pokemons",
)
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val avgSpawns: Double,
    val candy: String,
    val candyCount: Int,
    val egg: String,
    val height: String,
    val name: String,
    val num: String,
    val spawnChance: Double,
    val spawnTime: String,
    val weight: String,
)
