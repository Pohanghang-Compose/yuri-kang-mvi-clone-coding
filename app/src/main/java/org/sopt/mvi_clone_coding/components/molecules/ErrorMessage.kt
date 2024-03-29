package org.sopt.mvi_clone_coding.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorMessage(message: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            text = message,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.error,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun ErrorMessage_Preview() {
    ErrorMessage("ERROR")
}
