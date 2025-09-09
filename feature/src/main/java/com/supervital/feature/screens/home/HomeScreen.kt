package com.supervital.feature.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Text("Home Page Screen Content",
        fontSize = 30.sp,
        textAlign = TextAlign.Right,
        modifier = Modifier.padding(top = 15.dp)
    )

/*    Surface(
        modifier = Modifier.padding(top = 40.dp),
        color = Color.Transparent,
        shadowElevation = 4.dp,
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = "Пример текста на Surface",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Blue,
            modifier = Modifier.padding(16.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .padding(top = 80.dp, start = 80.dp, bottom = 20.dp)
        ) {
            Text(
                text = "Add",
                fontSize = 24.sp
            )
        }
    }

    ToastScreen()*/
}

@Composable
fun ToastScreen() {
    val context = LocalContext.current // Получаем текущий Context

    Button(
        onClick = {
            // Создаем и показываем Toast
            Toast.makeText(
                context, // Context
                "Привет, это мой тост!", // Сообщение
                Toast.LENGTH_SHORT // Длительность (LENGTH_SHORT или LENGTH_LONG)
            ).show() // Показываем тост
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Показать тост")
    }
}