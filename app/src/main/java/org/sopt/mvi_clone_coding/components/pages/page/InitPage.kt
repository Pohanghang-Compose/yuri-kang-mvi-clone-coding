package org.sopt.mvi_clone_coding.components.pages.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.molecules.BackButton
import org.sopt.mvi_clone_coding.components.organisms.DownloadRetryMessage
import org.sopt.mvi_clone_coding.components.organisms.DownloadingMessage
import org.sopt.mvi_clone_coding.components.pages.state.InitState

@Composable
fun InitPage(
    state: InitState,
    onRetry: () -> Unit
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White),
        ) {
            when (state.status) {
                UiStatus.Loading -> {
                    DownloadingMessage(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }

                is UiStatus.Failed -> {
                    DownloadRetryMessage(
                        // 재시도
                        onRetry = { onRetry() },
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }

                UiStatus.Success -> {
                    Text(
                        text = "InitPage",
                        color = Color.Black,
                    )
                }

                null -> Unit
            }
        }
    }
}
