package com.sanji.shoppinglist.domain

interface ShopListRepository {
    fun getShopItem(id: Int):ShopItem
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem:ShopItem)
    fun addShopItem(shopItem: ShopItem)
    fun getShopList(): List<ShopItem>
}