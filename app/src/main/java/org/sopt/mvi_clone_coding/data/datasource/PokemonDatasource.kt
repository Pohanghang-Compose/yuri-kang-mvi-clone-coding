package org.sopt.mvi_clone_coding.data.datasource

import android.content.Context
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.sopt.mvi_clone_coding.data.dto.PokemonItemDto

class PokemonDatasource(private val context: Context) {

    @OptIn(ExperimentalSerializationApi::class)
    fun fetchData(): List<PokemonItemDto> {
        val inputStream = context.assets.open(FILE_NAME)
        return Json.decodeFromStream(inputStream)
    }

    companion object {
        private const val FILE_NAME = "pokedex.json"
    }
}
