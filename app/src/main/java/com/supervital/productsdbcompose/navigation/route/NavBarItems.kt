package com.supervital.productsdbcompose.navigation.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import com.supervital.productsdbcompose.R

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = NavRoutes.Home.route,
            top_title_res = R.string.top_bar_title_home
        ),
        BarItem(
            title = "Contacts",
            image = Icons.Filled.Face,
            route = NavRoutes.Contacts.route,
            top_title_res = R.string.top_bar_title_contacts
        ),
        BarItem(
            title = "Weather",
            image = Icons.Filled.DateRange,
            route = NavRoutes.Weather.route,
            top_title_res = R.string.top_bar_title_weather
        ),
        BarItem(
            title = "Products",
            image = Icons.Filled.Star,
            route = NavRoutes.Products.route,
            top_title_res = R.string.top_bar_title_products
        ),
        BarItem(
            title = "About",
            image = Icons.Filled.Info,
            route = NavRoutes.About.route,
            top_title_res = R.string.top_bar_title_about
        )
    )
}