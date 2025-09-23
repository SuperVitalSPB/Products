package com.supervital.feature.screens.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supervital.domain.models.ProductInfo
import com.supervital.domain.usecase.ProductCreateUseCase
import com.supervital.domain.usecase.ProductsGetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsGetListUseCase: ProductsGetListUseCase,
    private val productCreateUseCase: ProductCreateUseCase
) : ViewModel() {

    fun getData() = productsGetListUseCase()

    fun insertProduct(nameProduct: String, numberQR: String) {
        viewModelScope.launch {
            productCreateUseCase(
                ProductInfo(
                    id = -1,
                    name = nameProduct,
                    numberQR = numberQR
                )
            )
        }

    }
}