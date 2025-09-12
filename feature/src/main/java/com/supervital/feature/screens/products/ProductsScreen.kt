package com.supervital.feature.screens.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProductsScreen(viewModel: ProductsViewModel = hiltViewModel()) {

    val productStateList = viewModel.getData()
        .collectAsState(initial = emptyList())
    val listState = rememberLazyListState()

    LaunchedEffect(productStateList.value.size) {
        listState.animateScrollToItem(index = productStateList.value.size)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 16.dp)
    ) {
    // ProductsDBComposeTheme {
        /*Column(
            Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {*/
            LazyColumn(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 15.dp),
                state = listState
            ) {
                items(productStateList.value) { product ->
                    Text(
                        modifier = Modifier.fillMaxWidth(), text = product.name, textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
    //    }
        Button(
            onClick = {
            // scan()
            viewModel.insertProduct(
                "Product ${productStateList.value.size + 1}", "dfasgsdfgdshgdfh"
            )
        }) {
            Text(text = "Create data")
        }
    }
}

/*
private val scanLauncher = registerForActivityResult(
    ScanContract()
) { result ->
    result.contents?.let {
        Toast.makeText(
            this,
            "Scan data: ${it}", Toast.LENGTH_SHORT
        ).show()
    }
}

private fun scan() {
    val options = ScanOptions()
    options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
    options.setPrompt("Scan a barcode")
    options.setCameraId(0)
    options.setBeepEnabled(false)
    options.setBarcodeImageEnabled(true)
    scanLauncher.launch(options)
}
*/
