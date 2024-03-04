package org.sopt.mvi_clone_coding.domain.usecase

import org.sopt.mvi_clone_coding.data.entity.PokemonDetails
import org.sopt.mvi_clone_coding.data.repository.PokemonRepository
import javax.inject.Inject

class LoadPokemonEvolutionUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
) {
    suspend operator fun invoke(id: Int): List<PokemonDetails> {
        val details = pokemonRepository.getById(id) ?: return emptyList()
        val prevNumbers = details.prevEvolutions.map { it.num }
        val nextNumbers = details.nextEvolutions.map { it.num }
        val allNumbers = prevNumbers + details.pokemon.num + nextNumbers
        return pokemonRepository.getByNumbers(allNumbers)
    }
}
