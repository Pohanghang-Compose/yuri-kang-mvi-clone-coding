package org.sopt.mvi_clone_coding.components.pages.sideeffect

sealed class LibrarySideEffect {
    data class ShowDetails(val id: Int) : LibrarySideEffect()
}
