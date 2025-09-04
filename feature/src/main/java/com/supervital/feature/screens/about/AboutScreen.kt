package com.supervital.feature.screens.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {
    Box {
        Text("About Page Screen Content",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 15.dp))
    }
}