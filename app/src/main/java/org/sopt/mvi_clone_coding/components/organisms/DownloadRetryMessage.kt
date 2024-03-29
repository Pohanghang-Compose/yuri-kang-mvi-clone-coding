package org.sopt.mvi_clone_coding.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mvi_clone_coding.components.molecules.ErrorMessage
import org.sopt.mvi_clone_coding.components.molecules.RetryButton

@Composable
fun DownloadRetryMessage(onRetry: (() -> Unit)? = null, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ErrorMessage(
            message = "Download Failed",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        RetryButton(
            onClick = onRetry,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun DownloadRetryMessage_Preview() {
    DownloadRetryMessage(modifier = Modifier.wrapContentSize(Alignment.Center))
}
