package com.trforcex.mods

import com.trforcex.mods.proxy.CommonProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

@Mod(
        modid = ModTheEnchanter.MOD_ID,
        name = ModTheEnchanter.NAME,
        version = ModTheEnchanter.VERSION,
        dependencies = "required-after:forgelin@[1.8.4,)",
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
        useMetadata = true // Use data provided in the "mcmod.info" file for the annotation
)
object ModTheEnchanter {
    const val MOD_ID = "theenchanter"
    const val NAME = "The Enchanter"
    const val VERSION = "1.0"

    @SidedProxy(
            modId = MOD_ID,
            clientSide = "com.trforcex.mods.proxy.ClientProxy",
            serverSide = "com.trforcex.mods.proxy.ServerProxy"
    )
    lateinit var proxy: CommonProxy
    lateinit var logger: Logger

    //region FML
    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) = proxy.init(event)

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) = proxy.postInit(event)
    //endregion
}