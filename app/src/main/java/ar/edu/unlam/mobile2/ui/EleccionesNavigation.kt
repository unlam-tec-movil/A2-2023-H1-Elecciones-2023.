package ar.edu.unlam.mobile2.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object EleccionesDestinations {
    const val HOME_ROUTE = "home"
    const val CANDIDATES_ROUTE = "candidates"
    const val SURVEY_ROUTE = "survey"
}

class EleccionesNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(EleccionesDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToCandidates: () -> Unit = {
        navController.navigate(EleccionesDestinations.CANDIDATES_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToSurvey: () -> Unit = {
        navController.navigate(EleccionesDestinations.SURVEY_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}