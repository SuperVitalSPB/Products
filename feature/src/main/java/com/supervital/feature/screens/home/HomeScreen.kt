package com.supervital.feature.screens.home

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(snackbarHostState: SnackbarHostState) {
    ColorAnimationExample(snackbarHostState)
}

@Composable
fun ColorAnimationExample(snackbarHostState: SnackbarHostState, modifier: Modifier = Modifier) {
    // Состояние, которое будет анимироваться
    var isColored by remember { mutableStateOf(false) }

    // Анимация для цвета
    val animatedColor by animateColorAsState(
        targetValue = if (isColored) Color.Red else Color.Blue,
        label = "MyAnimatedColor" // Добавьте label для более понятного отладки
    )

    Box(
        modifier = modifier
            .size(100.dp)
            .background(animatedColor) // Применяем анимированный цвет
    ) {
        Text("Home Page Screen Content",
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(15.dp)
        )

        SurShow(modifier)
        ShowScaffoldToast(snackbarHostState)

        Button(
            onClick = { isColored = !isColored }, // Изменяем состояние при нажатии
            modifier = modifier.align(Alignment.Center)
        ) {
            Text("Изменить цвет")
        }
    }
}

@Composable
fun ShowScaffoldToast(snackbarHostState: SnackbarHostState) {
    val coroutineScope = rememberCoroutineScope()
    Button(
        onClick = {
        // При нажатии на кнопку отображаем Snackbar
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = "Это сообщение из Snackbar!",
                actionLabel = "OK"
            )
        }
    }) {
        Text("Показать тост в Scaffold")
    }
}

@Composable
fun SurShow(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(top = 40.dp),
        color = Color.Transparent,
        shadowElevation = 4.dp,
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = "Пример текста на Surface",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Blue,
            modifier = modifier.padding(46.dp)
        )
        Button(
            onClick = {},
            modifier = modifier
                .padding(top = 80.dp, start = 80.dp, bottom = 20.dp)
        ) {
            Text(
                text = "Add",
                fontSize = 24.sp
            )
        }
    }

    ToastScreen(modifier)

}

@Composable
fun ToastScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current // Получаем текущий Context
    Button(
        modifier = modifier.padding(top = 50.dp, start = 16.dp),
        onClick = {
            // Создаем и показываем Toast
            Toast.makeText(
                context, // Context
                "Привет, это мой тост!", // Сообщение
                Toast.LENGTH_SHORT // Длительность (LENGTH_SHORT или LENGTH_LONG)
            ).show() // Показываем тост
        },

    ) {
        Text("Показать тост")
    }
}