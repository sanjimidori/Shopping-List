package com.sanji.shoppinglist.data

import com.sanji.shoppinglist.domain.ShopItem
import com.sanji.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var itemIncrementId = 0
    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = itemIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val tempItem = getShopItem(shopItem.id)
        shopList.remove(tempItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find{
            it.id == id
        } ?: throw RuntimeException("Element not found!")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}