package com.tpov.shoplist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}
