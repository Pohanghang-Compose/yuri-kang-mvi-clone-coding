package org.sopt.mvi_clone_coding.components.pages.state

import org.sopt.mvi_clone_coding.common.UiStatus

data class DetailsState(
    val status: UiStatus = UiStatus.Loading,
    // val details: PokemonDetails? = null,
    // val evolutions: List<PokemonDetails> = emptyList()
)