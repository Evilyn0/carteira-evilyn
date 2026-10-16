package com.example.carterinhadigital_evi.feature.aluno.carteirinha.presentation.component

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.unit.dp
import androidx.core.graphics.createBitmap
import androidx.core.graphics.set
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

@Composable
fun QrCode(
    conteudo: String,
    modifier: Modifier = Modifier
) {
    val bitmap = gerarQrCode(conteudo)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(ComposeColor.White)
            .padding(12.dp)
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = Modifier.size(180.dp)
        )
    }
}

fun gerarQrCode(
    conteudo: String,
    tamanho: Int = 512,
    margem: Int = 1
): Bitmap {
    val hints = mapOf(
        EncodeHintType.MARGIN to margem
    )

    val writer = QRCodeWriter()
    val bitMatrix = writer.encode(
        conteudo,
        BarcodeFormat.QR_CODE,
        tamanho,
        tamanho,
        hints
    )

    val bitmap = createBitmap(tamanho, tamanho)

    for (x in 0 until tamanho) {
        for (y in 0 until tamanho) {
            bitmap[x, y] = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
        }
    }

    return bitmap
}
