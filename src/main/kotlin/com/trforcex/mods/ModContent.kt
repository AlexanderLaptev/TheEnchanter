package com.trforcex.mods

import com.trforcex.mods.block.BlockTheEnchanter
import com.trforcex.mods.item.BaseItemUpgrade
import com.trforcex.mods.item.ItemVanillaTableUpgrade

object ModContent {
    val upgrades = ArrayList<BaseItemUpgrade>()

    val blockTheEnchanter = BlockTheEnchanter()

    val itemVanillaTableUpgrade = ItemVanillaTableUpgrade()
}
