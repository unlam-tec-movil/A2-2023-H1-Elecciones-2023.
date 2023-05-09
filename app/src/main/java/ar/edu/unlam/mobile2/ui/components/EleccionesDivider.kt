package ar.edu.unlam.mobile2.ui.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val DividerAlpha = 0.12f

@Composable
fun EleccionesDivider(
    modifier: Modifier = Modifier,
    //TODO Color
    color: Color = Color(0xFF8D8D8D).copy(alpha = DividerAlpha),
    thickness: Dp = 1.dp,
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
    )
}