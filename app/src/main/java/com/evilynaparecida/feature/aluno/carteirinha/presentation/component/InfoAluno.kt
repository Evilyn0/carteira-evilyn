package com.evilynaparecida.feature.aluno.carteirinha.presentation.component

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
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    fontSizeValue: TextUnit = 22.sp,
    fontWeightValue: FontWeight = FontWeight.Normal
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        LabelText(text = label)
        ValueText(
            text = value,
            fontSize = fontSizeValue,
            fontWeight = fontWeightValue
        )
    }
}
