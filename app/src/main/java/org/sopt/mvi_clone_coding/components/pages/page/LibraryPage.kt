package org.sopt.mvi_clone_coding.components.pages.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.molecules.ErrorMessage
import org.sopt.mvi_clone_coding.components.molecules.LoadingIndicator
import org.sopt.mvi_clone_coding.components.pages.state.LibraryState

@Composable
fun LibraryPage(
    state: LibraryState,
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White),
        ) {
            when (val status = state.status) {
                UiStatus.Success -> {
                    Text(
                        text = "LibraryPage",
                        color = Color.Black,
                    )
                }
                UiStatus.Loading -> {
                    LoadingIndicator(modifier = Modifier.fillMaxSize())
                }

                is UiStatus.Failed -> {
                    ErrorMessage(
                        message = status.message,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                else -> Unit
            }
        }
    }
}
