package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Ballot
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.HowToVote
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.components.SurveyTest
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
            modifier = Modifier.fillMaxSize()
        ) {
            AppMenu(
                navController = navController,
                currentRoute = currentRoute,
                navigateToHome = navigationActions.navigateToHome,
                navigateToCandidates = navigationActions.navigateToCandidates,
                navigateToSurvey = navigationActions.navigateToSurvey,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppMenu(
    navController: NavHostController = rememberNavController(),
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToCandidates: () -> Unit,
    navigateToSurvey: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var shouldShowSettingsDialog by remember { mutableStateOf(false) }

    if (shouldShowSettingsDialog) {
        SettingsDialog(
            onDismiss = { shouldShowSettingsDialog = false },
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Elecciones 2023",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color(0xff75AADB)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Filled.Ballot,
                            contentDescription = null,
                            tint = Color(0xff75AADB)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null,
                            tint = Color(0xff75AADB)
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(stringResource(id = R.string.action_reset_data)) },
                            onClick = { /* TODO */ },
                            leadingIcon = {
                                Icon(
                                    Icons.Outlined.Delete,
                                    contentDescription = null
                                )
                            })
                        DropdownMenuItem(
                            text = { Text(stringResource(id = R.string.action_settings)) },
                            onClick = { shouldShowSettingsDialog = true },
                            leadingIcon = {
                                Icon(
                                    Icons.Outlined.Settings,
                                    contentDescription = null
                                )
                            })
                    }
                }
            )
        },
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

@Composable
fun SettingsDialog(
    onDismiss: () -> Unit,
    //TODO
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = stringResource(id = R.string.action_settings),
                style = MaterialTheme.typography.titleLarge,
            )
        },
        text = {
            Divider()
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 15.dp)
            ) {
                SurveyTest("Tema", listOf("Modo oscuro", "Default"))
            }
        },
        confirmButton = {
            Text(
                text = "OK",
                style = MaterialTheme.typography.labelLarge,
                color = Color(0xff75AADB),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { onDismiss() },
            )
        },
    )
}
