package org.sopt.mvi_clone_coding.components.pages.viewmodel

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.pages.sideeffect.LibrarySideEffect
import org.sopt.mvi_clone_coding.components.pages.state.LibraryState

class LibraryViewModel : ContainerHost<LibraryState, LibrarySideEffect>, ViewModel() {
    override val container = container<LibraryState, LibrarySideEffect>(
        LibraryState(),
    )

    fun init() = intent {
        reduce {
            state.copy(status = UiStatus.Loading)
        }
    }
}
