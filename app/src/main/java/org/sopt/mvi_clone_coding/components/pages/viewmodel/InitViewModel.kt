package org.sopt.mvi_clone_coding.components.pages.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.pages.sideeffect.InitSideEffect
import org.sopt.mvi_clone_coding.components.pages.state.InitState
import org.sopt.mvi_clone_coding.domain.usecase.FetchAllPokemonUseCase
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    private val fetchAllPokemonUseCase: FetchAllPokemonUseCase,
) : ContainerHost<InitState, InitSideEffect>, ViewModel() {

    override val container = container<InitState, InitSideEffect>(
        InitState(),
    )

    init {
        fetchData()
    }

    private fun fetchData() {
        intent {
            reduce { state.copy(status = UiStatus.Loading) }
            if (fetchAllPokemonUseCase()) {
                reduce { state.copy(status = UiStatus.Success) }
                postSideEffect(InitSideEffect.Completed)
            } else {
                reduce { state.copy(status = UiStatus.Failed()) }
            }
        }
    }

    fun retry() {
        if (container.stateFlow.value.status != UiStatus.Loading) {
            fetchData()
        }
    }
}
