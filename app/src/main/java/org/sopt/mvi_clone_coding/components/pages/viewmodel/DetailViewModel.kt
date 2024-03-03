package org.sopt.mvi_clone_coding.components.pages.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.pages.sideeffect.DetailsSideEffect
import org.sopt.mvi_clone_coding.components.pages.state.DetailsState
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ContainerHost<DetailsState, DetailsSideEffect>,
    ViewModel() {

    override val container = container<DetailsState, DetailsSideEffect>(
        DetailsState(),
    )

    fun init() = intent {
        reduce {
            state.copy(status = UiStatus.Loading)
        }
    }
}
