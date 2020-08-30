package com.trforcex.mods.util

import com.trforcex.mods.ModTheEnchanter
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.util.ResourceLocation

object ModUtils {
    // RL stands for "resource location"
    fun makeRLstr(path: String) = "${ModTheEnchanter.MOD_ID}:$path"
    fun makeRL(path: String) = ResourceLocation(makeRLstr(path))

    fun makeModelRL(rl: ResourceLocation, variant: String = "inventory") = ModelResourceLocation("$rl", variant)
    fun makeModelRL(location: String, variant: String = "inventory") = ModelResourceLocation(location, variant)

    fun makeTranslationKey(rl: ResourceLocation) = "${ModTheEnchanter.MOD_ID}.${rl.path}"
}
