package com.supervital.productsdbcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.supervital.feature.screens.about.AboutScreen
import com.supervital.feature.screens.home.HomeScreen
import com.supervital.feature.screens.products.ProductsScreen
import com.supervital.feature.screens.weather.WeatherScreen
import com.supervital.navigationcompose.theme.NavigationComposeTheme
import com.supervital.productsdbcompose.navigation.route.BarItem
import com.supervital.productsdbcompose.navigation.route.NavBarItems
import com.supervital.productsdbcompose.navigation.route.NavRoutes

@Composable
fun MainScreenWithNavigationAndListScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = NavBarItems.BarItems
    val selectedBarItem = NavBarItems.BarItems[selectedIndex]
    val navController: NavHostController = rememberNavController()

    Scaffold(
        topBar = { TopBarAppl(navController, selectedBarItem) },
        bottomBar = { NavigationBarAppl(items, selectedIndex,{ index -> selectedIndex = index }) }
    ) { innerPadding ->
        NavigationComposeTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 5.dp)
                    .padding(innerPadding) // Apply padding from Scaffold
            ) {
                when (selectedBarItem.route) {
                    NavRoutes.Home.route -> HomeScreen()
                    NavRoutes.Contacts.route -> {}//ContactsScreen()
                    NavRoutes.Weather.route -> WeatherScreen()
                    NavRoutes.Products.route -> ProductsScreen()
                    NavRoutes.About.route -> AboutScreen()
                }
            }
        }
    }
}

@Composable
fun NavigationBarAppl(items: List<BarItem>, selectedIndex: Int, setSelectedIndex: (Int) -> Unit) {
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.image,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = selectedIndex == index,
                onClick = { setSelectedIndex(index) }
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class) // Пометка для экспериментальной функции
@Composable
fun TopBarAppl(navController: NavHostController = rememberNavController(), selectedBarItem: BarItem) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(selectedBarItem.top_title_res)) }, // Текст в заголовке
        navigationIcon = { // Иконка для навигации (например, кнопка "назад")
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack, // Используйте иконку из Material Icons
                    contentDescription = "Назад" // Описание для доступности
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF007AFF), // Цвет фона панели
            titleContentColor = Color.White, // Цвет текста заголовка
            navigationIconContentColor = Color.White, // Цвет иконки навигации
            actionIconContentColor = Color.White // Цвет иконок действий
        )
    )
}