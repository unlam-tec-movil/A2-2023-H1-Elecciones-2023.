package ar.edu.unlam.mobile2.ui.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.ui.components.SurveyTest

@Composable
fun SurveyRoute() {
    SurveyScreen()
}

@Composable
fun SurveyScreen() {
    Column(
        modifier = Modifier
            .padding(50.dp)
    ) {
        SurveyTest("Pregunta 1 de 15", listOf("De acuerdo", "N/A", "En desacuerdo"))
    }
}