package org.sopt.mvi_clone_coding.domain.usecase

import org.sopt.mvi_clone_coding.data.repository.ConfigRepository
import org.sopt.mvi_clone_coding.data.repository.PokemonRepository
import javax.inject.Inject

class FetchAllPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val configRepository: ConfigRepository,
) {
    suspend operator fun invoke(): Boolean {
        return if (!configRepository.createdDatabase) {
            pokemonRepository.clear()
            pokemonRepository.fetch().apply { configRepository.createdDatabase = this }
        } else {
            true
        }
    }
}
