package org.sopt.mvi_clone_coding.domain.usecase

import org.sopt.mvi_clone_coding.data.repository.PokemonRepository
import javax.inject.Inject

class LoadPokemonDetailsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) {
    suspend operator fun invoke(id: Int) = pokemonRepository.getById(id)
}
