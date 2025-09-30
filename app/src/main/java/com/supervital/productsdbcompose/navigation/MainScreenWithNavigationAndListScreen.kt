package com.supervital.productsdbcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.supervital.feature.screens.about.AboutScreen
import com.supervital.feature.screens.contacts.ContactsScreen
import com.supervital.feature.screens.home.HomeScreen
import com.supervital.feature.screens.products.ProductsScreen
import com.supervital.feature.screens.weather.WeatherScreen
import com.supervital.productsdbcompose.R
import com.supervital.productsdbcompose.navigation.route.BarItem
import com.supervital.productsdbcompose.navigation.route.NavBarItems
import com.supervital.productsdbcompose.navigation.route.NavRoutes
import kotlinx.coroutines.launch

@Composable
fun MainScreenWithNavigationAndListScreen(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = NavBarItems.getBarItem( backStackEntry?.destination?.route)

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val showFloatButton by remember { mutableStateOf(false)  }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        floatingActionButton = {
                if (showFloatButton) {
                    ExtendedFloatingActionButton(
                        text = { Text("Show snackbar") },
                        icon = { Icon(Icons.Filled.AccountBox, contentDescription = "") },
                        onClick = {
                            scope.launch {
                                val result = snackbarHostState
                                    .showSnackbar(
                                        message = "Snackbar",
                                        actionLabel = "Action",
                                        // Defaults to SnackbarDuration.Short
                                        duration = SnackbarDuration.Indefinite
                                    )
                                when (result) {
                                    SnackbarResult.ActionPerformed -> {
                                        /* Handle snackbar action performed */
                                    }

                                    SnackbarResult.Dismissed -> {
                                        /* Handle snackbar dismissed */
                                    }
                                }
                            }
                        }
                    )
                }
            },
            topBar = {
            TopBarAppl(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        bottomBar = {
            NavigationBottomBar(NavBarItems.barItems, currentScreen, { item ->
                navController.navigate(item.route)
            }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavRoutes.Home.route,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                composable(NavRoutes.Home.route) {
                    HomeScreen(snackbarHostState)
                }
                composable(NavRoutes.Contacts.route) {
                    ContactsScreen()
                }
                composable(NavRoutes.Weather.route) {
                    WeatherScreen()
                }
                composable(NavRoutes.Products.route) {
                    ProductsScreen()
                }
                composable(NavRoutes.About.route) {
                    AboutScreen()
                }
            }
        }
    }
}

@Composable
fun NavigationBottomBar(items: List<BarItem>, selectedItem: BarItem, navigate: (BarItem) -> Unit) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        item.image,
                        contentDescription = item.bottomTitle
                    )
                },
                label = { Text(item.bottomTitle) },
                selected = selectedItem == item,
                onClick = { navigate(item) }
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class) // Пометка для экспериментальной функции
@Composable
fun TopBarAppl(
    currentScreen: BarItem,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.topTitleRes)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
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