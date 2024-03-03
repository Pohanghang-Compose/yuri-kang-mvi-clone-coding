package org.sopt.mvi_clone_coding.components.pages.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.molecules.BackButton
import org.sopt.mvi_clone_coding.components.molecules.ErrorMessage
import org.sopt.mvi_clone_coding.components.molecules.LoadingIndicator
import org.sopt.mvi_clone_coding.components.pages.state.DetailsState

@Composable
fun DetailsPage(
    state: DetailsState,
    onBack: () -> Unit,
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            when (val status = state.status) {
                UiStatus.Success -> {
                    Text(
                        text = "DetailsPage",
                        color = Color.Black,
                    )
                    BackButton(
                        onClick = { onBack.invoke() },
                        modifier = Modifier
                            .size(48.dp)
                            .padding(top = 12.dp, start = 12.dp)
                            .align(Alignment.TopStart)
                    )
                }

                UiStatus.Loading -> {
                    LoadingIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                    )
                }

                is UiStatus.Failed -> {
                    ErrorMessage(
                        message = status.message,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                    )
                }

                else -> Unit
            }
        }
    }
}
