package ar.edu.unlam.mobile2.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.ui.candidates.CandidatesRoute
import ar.edu.unlam.mobile2.ui.home.HomeRoute
import ar.edu.unlam.mobile2.ui.survey.SurveyRoute

@Composable
fun EleccionesNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = EleccionesDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    )
    {
        composable(EleccionesDestinations.HOME_ROUTE) {
            HomeRoute()
        }
        composable(EleccionesDestinations.CANDIDATES_ROUTE) {
            CandidatesRoute()
        }
        composable(EleccionesDestinations.SURVEY_ROUTE) {
            SurveyRoute()
        }
    }
}