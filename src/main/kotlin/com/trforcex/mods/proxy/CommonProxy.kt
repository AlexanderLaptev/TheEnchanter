package com.trforcex.mods.proxy

import com.trforcex.mods.ModContent
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod.EventBusSubscriber
open class CommonProxy {

    open fun preInit(event: FMLPreInitializationEvent) {}

    open fun init(event: FMLInitializationEvent) {}

    open fun postInit(event: FMLPostInitializationEvent) {}

    companion object {
        @SubscribeEvent
        @JvmStatic
        fun registerBlocks(event: RegistryEvent.Register<Block>) {
            event.registry.register(ModContent.blockTheEnchanter)
        }

        @SubscribeEvent
        @JvmStatic
        fun registerItems(event: RegistryEvent.Register<Item>) {
            val registry = event.registry
            registry.register(ModContent.blockTheEnchanter.itemBlock)

            for (upgrade in ModContent.upgrades) registry.register(upgrade)
        }
    }
}
