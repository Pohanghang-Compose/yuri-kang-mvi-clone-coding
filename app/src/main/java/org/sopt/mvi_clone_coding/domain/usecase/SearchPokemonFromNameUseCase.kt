package org.sopt.mvi_clone_coding.domain.usecase

import org.sopt.mvi_clone_coding.data.entity.PokemonDetails
import org.sopt.mvi_clone_coding.data.repository.PokemonRepository
import javax.inject.Inject

class SearchPokemonFromNameUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) {
    suspend operator fun invoke(searchText: String): List<PokemonDetails> {
        return if (searchText.isEmpty()) {
            pokemonRepository.getAll()
        } else {
            pokemonRepository.getAll().filter { it.pokemon.name.contains(searchText) }
        }
    }
}
