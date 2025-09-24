package com.supervital.feature.screens.home

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    ColorAnimationExample()

/*
    Text("Home Page Screen Content",
        fontSize = 30.sp,
        textAlign = TextAlign.Right,
        modifier = Modifier.padding(top = 15.dp)
    )
*/

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
fun ColorAnimationExample() {
    // Состояние, которое будет анимироваться
    var isColored by remember { mutableStateOf(false) }

    // Анимация для цвета
    val animatedColor by animateColorAsState(
        targetValue = if (isColored) Color.Red else Color.Blue,
        label = "MyAnimatedColor" // Добавьте label для более понятного отладки
    )

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(animatedColor) // Применяем анимированный цвет
    ) {
        Button(
            onClick = { isColored = !isColored }, // Изменяем состояние при нажатии
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Изменить цвет")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColorAnimationExample() {
    ColorAnimationExample()
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