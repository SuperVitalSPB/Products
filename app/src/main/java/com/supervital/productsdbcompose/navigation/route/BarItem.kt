package com.supervital.productsdbcompose.navigation.route

import androidx.compose.ui.graphics.vector.ImageVector

data class BarItem(
    val bottomTitle: String,
    val image: ImageVector,
    val route: String,
    val topTitleRes: Int
)