package com.trforcex.mods.item

import com.trforcex.mods.ModContent
import com.trforcex.mods.util.ModUtils
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.client.model.ModelLoader

/**
 * A base class for all upgrades (and thus all mod items)
 *
 * @param regName registry name of the upgrade
 */
abstract class BaseItemUpgrade(regName: String) : Item() {
    init {
        registryName = ModUtils.makeRL(regName)
        translationKey = ModUtils.makeTranslationKey(registryName!!)
        creativeTab = CreativeTabs.MISC
        ModContent.upgrades += this
    }

    fun initModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, ModUtils.makeModelRL(registryName!!))
    }

    override fun onItemUse(
        player: EntityPlayer,
        worldIn: World,
        pos: BlockPos,
        hand: EnumHand,
        facing: EnumFacing,
        hitX: Float,
        hitY: Float,
        hitZ: Float
    ): EnumActionResult {
        val blockState = worldIn.getBlockState(pos)
        val te = worldIn.getTileEntity(pos)

        return if (isBlockStateUpgradable(player, worldIn, blockState, pos, te)) {
            upgradeBlock(player, worldIn, blockState, pos, te)
            EnumActionResult.SUCCESS
        } else EnumActionResult.FAIL
    }

    /**
     * Checks if the given blockstate is upgradable by this upgrade.
     *
     * @param player the player who tried to upgrade block
     * @param state the state that is checked
     * @param te the tile entity of the block, if present
     */
    abstract fun isBlockStateUpgradable(
        player: EntityPlayer,
        worldIn: World,
        state: IBlockState,
        pos: BlockPos,
        te: TileEntity?
    ): Boolean

    /**
     * Upgrades the given blockstate.
     */
    abstract fun upgradeBlock(
        player: EntityPlayer,
        worldIn: World,
        state: IBlockState,
        pos: BlockPos,
        te: TileEntity?
    )
}
