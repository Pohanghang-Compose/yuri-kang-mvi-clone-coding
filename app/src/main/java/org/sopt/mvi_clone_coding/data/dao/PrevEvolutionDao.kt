package org.sopt.mvi_clone_coding.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.sopt.mvi_clone_coding.data.entity.PrevEvolutionEntity

@Dao
interface PrevEvolutionDao {
    @Insert
    suspend fun insert(prevEvolution: PrevEvolutionEntity)

    @Insert
    suspend fun insertAll(prevEvolutions: List<PrevEvolutionEntity>)

    @Update
    suspend fun update(prevEvolution: PrevEvolutionEntity)

    @Delete
    suspend fun delete(prevEvolution: PrevEvolutionEntity)

    @Query("SELECT * FROM next_evolutions where pokemonId = :pokemonId")
    suspend fun findNextEvolutions(pokemonId: Int): List<PrevEvolutionEntity>
}
