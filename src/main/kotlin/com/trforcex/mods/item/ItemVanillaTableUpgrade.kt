package com.trforcex.mods.item

import com.trforcex.mods.ModContent
import net.minecraft.block.BlockEnchantmentTable
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemDye
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ItemVanillaTableUpgrade : BaseItemUpgrade("vanilla_upgrade") {
    companion object {
        const val PARTICLES_AMOUNT = 15
    }

    override fun isBlockStateUpgradable(
        player: EntityPlayer,
        worldIn: World,
        blockState: IBlockState,
        pos: BlockPos,
        te: TileEntity?
    ): Boolean = blockState.block is BlockEnchantmentTable

    override fun upgradeBlock(
        player: EntityPlayer,
        worldIn: World,
        blockState: IBlockState,
        pos: BlockPos,
        te: TileEntity?
    ) {
        if (!worldIn.isRemote) {
            val table = blockState.block as BlockEnchantmentTable
            // TODO: drop lapis if present
            worldIn.setBlockState(pos, ModContent.blockTheEnchanter.defaultState)
        } else ItemDye.spawnBonemealParticles(worldIn, pos.offset(EnumFacing.UP), 15)
    }
}
