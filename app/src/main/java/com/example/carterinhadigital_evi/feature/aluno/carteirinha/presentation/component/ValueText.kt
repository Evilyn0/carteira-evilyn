package com.example.carterinhadigital_evi.feature.aluno.carteirinha.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ValueText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 22.sp,
    fontWeight: FontWeight = FontWeight.Medium
) {
    Text(
        text = text,
        fontSize = fontSize,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = fontWeight,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}
