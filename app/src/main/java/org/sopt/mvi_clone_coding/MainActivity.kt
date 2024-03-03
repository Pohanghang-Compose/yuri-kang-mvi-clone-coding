package org.sopt.mvi_clone_coding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.primarySurface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.mvi_clone_coding.components.pages.DetailsPage
import org.sopt.mvi_clone_coding.components.pages.InitPage
import org.sopt.mvi_clone_coding.components.pages.LibraryPage
import org.sopt.mvi_clone_coding.ui.theme.MviclonecodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MviclonecodingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    window.statusBarColor =
                        androidx.compose.material.MaterialTheme.colors.primarySurface.toArgb()
                    Box(modifier = Modifier.fillMaxSize()) {
                        val navController = rememberNavController()
                        NavHost(navController, startDestination = Screen.Init.route) {
                            addInit(navController = navController)
                            addLibrary(navController = navController)
                            addDetails(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

private fun NavGraphBuilder.addInit(navController: NavController) {
    composable(route = Screen.Init.route) {
        // 버튼 클릭 시 화면 이동
        InitPage(
            onNavigateToLibrary = { navController.navigate(Screen.Library.route) },
        )
    }
}

private fun NavGraphBuilder.addLibrary(navController: NavController) {
    composable(route = Screen.Library.route) {
        LibraryPage(
            onNavigateToDetails = { navController.navigate(Screen.Details.route) },
        )
    }
}

private fun NavGraphBuilder.addDetails(navController: NavController) {
    composable(route = Screen.Details.route) {
        DetailsPage(
            onNavigateToInit = { navController.navigate(Screen.Init.route) },
        )
    }
}
