package com.supervital.productsdbcompose.navigation.route

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Contacts : NavRoutes("contacts")
    object Weather : NavRoutes("weather")
    object Products : NavRoutes("products")
    object About : NavRoutes("about")
}