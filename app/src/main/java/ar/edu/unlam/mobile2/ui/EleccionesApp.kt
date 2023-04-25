package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.HowToVote
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.theme.EleccionesTheme

@Composable
fun EleccionesApp() {
    EleccionesTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            EleccionesNavigationActions(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: EleccionesDestinations.HOME_ROUTE

        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            AppMenu(
                currentRoute = currentRoute,
                navigateToHome = navigationActions.navigateToHome,
                navigateToCandidates = navigationActions.navigateToCandidates,
                navigateToSurvey = navigationActions.navigateToSurvey,
                navController = navController,
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppMenu(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToCandidates: () -> Unit,
    navigateToSurvey: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Groups, contentDescription = null) },
                    label = { Text(stringResource(id = R.string.candidates_title)) },
                    selected = currentRoute == EleccionesDestinations.CANDIDATES_ROUTE,
                    onClick = { navigateToCandidates(); }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text(stringResource(id = R.string.home_title)) },
                    selected = currentRoute == EleccionesDestinations.HOME_ROUTE,
                    onClick = { navigateToHome(); }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.HowToVote, contentDescription = null) },
                    label = { Text(stringResource(id = R.string.survey_title)) },
                    selected = currentRoute == EleccionesDestinations.SURVEY_ROUTE,
                    onClick = { navigateToSurvey(); }
                )
            }
        }
    ) { innerPadding ->
        EleccionesNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
