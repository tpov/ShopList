package com.sumin.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumin.shoppinglist.data.ShopListRepositoryImpl
import com.tpov.shoplist.domain.DeleteShopItemUseCase
import com.tpov.shoplist.domain.EditShopItemUseCase
import com.tpov.shoplist.domain.GetShopListUseCase
import com.tpov.shoplist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItemUseCase(newItem)
    }
}
