package org.sopt.mvi_clone_coding.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import javax.inject.Singleton

@Singleton

@Entity(
    tableName = "next_evolutions",
    foreignKeys = [
        ForeignKey(
            entity = PokemonEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("pokemonId"),
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
class NextEvolutionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pokemonId: Int,
    val name: String,
    val num: String,
)
