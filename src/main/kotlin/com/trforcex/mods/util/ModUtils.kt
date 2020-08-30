package com.trforcex.mods.util

import com.trforcex.mods.ModTheEnchanter
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

object ModUtils {
    // RL stands for "resource location"
    fun makeRLstr(path: String) = "${ModTheEnchanter.MOD_ID}:$path"
    fun makeRL(path: String) = ResourceLocation(makeRLstr(path))
    fun makeModelRL(location: String, variant: String = "inventory") = ModelResourceLocation(location, variant)

    fun makeTranslationKey(item: Item) = "${ModTheEnchanter.MOD_ID}.${item.registryName!!.path}"
    fun makeTranslationKey(block: Block) = "${ModTheEnchanter.MOD_ID}.${block.registryName!!.path}"
}
