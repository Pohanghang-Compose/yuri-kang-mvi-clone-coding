package org.sopt.mvi_clone_coding.components.pages.state

import org.sopt.mvi_clone_coding.common.UiStatus

data class LibraryState(
    val status: UiStatus = UiStatus.Loading,
    // val searchText: String = "",
    // val detailsList: List<PokemonDetails> = emptyList()
)
