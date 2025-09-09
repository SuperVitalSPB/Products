package com.supervital.productsdbcompose.navigation.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import com.supervital.productsdbcompose.R

object NavBarItems {
    val barItems = listOf(
        BarItem(
            bottomTitle = "Home",
            image = Icons.Filled.Home,
            route = NavRoutes.Home.route,
            topTitleRes = R.string.top_bar_title_home
        ),
        BarItem(
            bottomTitle = "Contacts",
            image = Icons.Filled.Face,
            route = NavRoutes.Contacts.route,
            topTitleRes = R.string.top_bar_title_contacts
        ),
        BarItem(
            bottomTitle = "Weather",
            image = Icons.Filled.DateRange,
            route = NavRoutes.Weather.route,
            topTitleRes = R.string.top_bar_title_weather
        ),
        BarItem(
            bottomTitle = "Products",
            image = Icons.Filled.Star,
            route = NavRoutes.Products.route,
            topTitleRes = R.string.top_bar_title_products
        ),
        BarItem(
            bottomTitle = "About",
            image = Icons.Filled.Info,
            route = NavRoutes.About.route,
            topTitleRes = R.string.top_bar_title_about
        )
    )

    fun getBarItem(route: String?): BarItem  {
        val found = barItems.filter { barItem ->
            barItem.route == route
        }
        return if (found == emptyList<BarItem>()) barItems[0] else found[0]
    }

}