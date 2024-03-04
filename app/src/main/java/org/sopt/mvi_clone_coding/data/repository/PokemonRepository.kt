package org.sopt.mvi_clone_coding.data.repository

import org.sopt.mvi_clone_coding.data.entity.PokemonDetails

interface PokemonRepository {
    suspend fun fetch(): Boolean
    fun clear()
    suspend fun getAll(): List<PokemonDetails>
    suspend fun getById(id: Int): PokemonDetails?
    suspend fun getByNumbers(numbers: List<String>): List<PokemonDetails>
}