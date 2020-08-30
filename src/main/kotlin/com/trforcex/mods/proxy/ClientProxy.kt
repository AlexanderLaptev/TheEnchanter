package com.trforcex.mods.proxy

//import com.trforcex.mods.block.tileentity.TileEntityTheEnchanter
//import com.trforcex.mods.block.tileentity.renderer.TileEntityTheEnchanterRenderer
import com.trforcex.mods.ModContent
import net.minecraftforge.client.event.ModelRegistryEvent
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
            for (upgrade in ModContent.upgrades) upgrade.initModels()
        }
    }

    override fun init(event: FMLInitializationEvent) {
        super.init(event)
//        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTheEnchanter::class.java, TileEntityTheEnchanterRenderer())
    }
}
