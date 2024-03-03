package org.sopt.mvi_clone_coding.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.sopt.mvi_clone_coding.data.entity.ImageEntity

@Dao
interface ImageDao {
    @Insert
    suspend fun insert(image: ImageEntity)

    @Insert
    suspend fun insertAll(images: List<ImageEntity>)

    @Update
    suspend fun update(image: ImageEntity)

    @Delete
    suspend fun delete(image: ImageEntity)

    @Query("SELECT * FROM images where pokemonId = :pokemonId")
    suspend fun findImageByPokemonId(pokemonId: Int): ImageEntity
}
