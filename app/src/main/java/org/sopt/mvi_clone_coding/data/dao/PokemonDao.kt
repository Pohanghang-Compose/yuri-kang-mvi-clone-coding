package org.sopt.mvi_clone_coding.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.sopt.mvi_clone_coding.data.entity.PokemonDetails
import org.sopt.mvi_clone_coding.data.entity.PokemonEntity

@Dao
interface PokemonDao {
    @Insert
    suspend fun insert(pokemon: PokemonEntity)

    @Insert
    suspend fun insertAll(pokemons: List<PokemonEntity>)

    @Update
    suspend fun update(pokemon: PokemonEntity)

    @Delete
    suspend fun delete(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemons WHERE id=:id")
    suspend fun getById(id: Int): PokemonDetails?

    @Query("SELECT * FROM pokemons WHERE num IN (:numbers)")
    suspend fun getByNumbers(numbers: List<String>): List<PokemonDetails>

    @Query("SELECT * FROM pokemons")
    suspend fun getAll(): List<PokemonDetails>
}
