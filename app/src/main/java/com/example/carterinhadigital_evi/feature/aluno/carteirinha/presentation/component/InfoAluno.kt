package com.example.carterinhadigital_evi.feature.aluno.carteirinha.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun InfoAluno(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    fontSizeValue: TextUnit = 22.sp,
    fontWeightValue: FontWeight = FontWeight.Medium
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        LabelText(
            text = label
        )
        ValueText(
            text = value,
            fontSize = fontSizeValue,
            fontWeight = fontWeightValue
        )
    }
}
