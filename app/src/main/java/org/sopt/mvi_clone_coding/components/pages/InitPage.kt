package org.sopt.mvi_clone_coding.components.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.mvi_clone_coding.components.molecules.BackButton

@Composable
fun InitPage(
    onNavigateToLibrary: () -> Unit,
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White),
        ) {
            Text(
                text = "InitPage",
                color = Color.Black,
            )
        }
        BackButton(
            onClick = { onNavigateToLibrary.invoke() },
            modifier = Modifier
                .size(48.dp)
                .padding(top = 12.dp, start = 12.dp),
        )
    }
}
