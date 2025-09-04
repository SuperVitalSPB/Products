package com.supervital.feature.screens.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.supervital.feature.screens.products.theme.ProductsDBComposeTheme

@Composable
fun ProductsScreen(viewModel: ProductsViewModel = hiltViewModel()) {

    val productStateList = viewModel.getData()
        .collectAsState(initial = emptyList())
    var counter by remember { mutableIntStateOf(0) }

    ProductsDBComposeTheme {
        Column(
            Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
            ) {
                items(productStateList.value) { product ->
                    Text(
                        modifier = Modifier.fillMaxWidth(), text = product.name, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            Button(onClick = {
                // scan()
                viewModel.insertProduct(
                    "Product ${counter++}", "dfasgsdfgdshgdfh"
                )
            }) {
                Text(text = "Create data")
            }
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
