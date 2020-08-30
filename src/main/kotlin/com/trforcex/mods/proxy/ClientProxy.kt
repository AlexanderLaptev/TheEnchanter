package com.trforcex.mods.proxy

import com.trforcex.mods.ModContent
//import com.trforcex.mods.block.tileentity.TileEntityTheEnchanter
//import com.trforcex.mods.block.tileentity.renderer.TileEntityTheEnchanterRenderer
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side

@Mod.EventBusSubscriber(Side.CLIENT)
class ClientProxy : CommonProxy() {
    companion object {
        @SubscribeEvent
        @JvmStatic
        fun registerModels(event: ModelRegistryEvent) {
            ModContent.blockTheEnchanter.initModels()
        }
    }

    override fun init(event: FMLInitializationEvent) {
        super.init(event)
//        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTheEnchanter::class.java, TileEntityTheEnchanterRenderer())
    }
}
