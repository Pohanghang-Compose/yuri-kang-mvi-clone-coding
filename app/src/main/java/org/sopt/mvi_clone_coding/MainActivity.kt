package org.sopt.mvi_clone_coding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.primarySurface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import org.sopt.mvi_clone_coding.common.UiStatus
import org.sopt.mvi_clone_coding.components.pages.page.DetailsPage
import org.sopt.mvi_clone_coding.components.pages.page.InitPage
import org.sopt.mvi_clone_coding.components.pages.page.LibraryPage
import org.sopt.mvi_clone_coding.components.pages.sideeffect.InitSideEffect
import org.sopt.mvi_clone_coding.components.pages.state.DetailsState
import org.sopt.mvi_clone_coding.components.pages.state.LibraryState
import org.sopt.mvi_clone_coding.components.pages.viewmodel.InitViewModel
import org.sopt.mvi_clone_coding.ui.theme.MviclonecodingTheme

@AndroidEntryPoint
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
        val iniViewModel: InitViewModel = hiltViewModel()
        val state by iniViewModel.collectAsState()
        iniViewModel.collectSideEffect {
            when (it) {
                is InitSideEffect.Completed -> {
                    navController.navigate(route = Screen.Library.route)
                }
            }
        }

        InitPage(
            state = state,
            onRetry = { iniViewModel.retry() },
        )
    }
}

private fun NavGraphBuilder.addLibrary(navController: NavController) {
    composable(route = Screen.Library.route) {
        LibraryPage(
            state = LibraryState(
                status = UiStatus.Success,
            ),
        )
    }
}

private fun NavGraphBuilder.addDetails(navController: NavController) {
    composable(route = Screen.Details.route) {
        DetailsPage(
            state = DetailsState(
                status = UiStatus.Success,
            ),
            onBack = { navController.popBackStack() },
            // onNavigateToInit = { navController.navigate(Screen.Init.route) },
        )
    }
}
