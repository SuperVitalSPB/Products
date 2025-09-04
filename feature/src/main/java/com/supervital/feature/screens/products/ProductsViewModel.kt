package com.supervital.feature.screens.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supervital.domain.models.ProductInfo
import com.supervital.domain.usecase.ProductCreateUseCase
import com.supervital.domain.usecase.ProductGetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productGetListUseCase: ProductGetListUseCase,
    private val productCreateUseCase: ProductCreateUseCase
) : ViewModel() {

    fun getData() = productGetListUseCase.getAllProducts()

    fun insertProduct(nameProduct: String, numberQR: String) {
        viewModelScope.launch {
            productCreateUseCase.insertProduct(
                ProductInfo(
                    id = -1,
                    name = nameProduct,
                    numberQR = numberQR
                )
            )
        }

    }
}