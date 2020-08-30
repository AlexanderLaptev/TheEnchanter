package com.trforcex.mods.block

//import com.trforcex.mods.block.tileentity.TileEntityTheEnchanter
import com.trforcex.mods.util.ModUtils
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockFaceShape
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.client.model.ModelLoader

class BlockTheEnchanter : BlockContainer(Material.ROCK, MapColor.PURPLE) {
    companion object {
        const val REG_NAME = "the_enchanter"
    }

    val itemBlock = ItemBlock(this)
    private val aabb = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0)

    init {
        registryName = ModUtils.makeRL(REG_NAME)
        lightOpacity = 0
        creativeTab = CreativeTabs.DECORATIONS
        translationKey = ModUtils.makeTranslationKey(this)

        itemBlock.registryName = registryName
    }

    override fun onBlockActivated(
        worldIn: World,
        pos: BlockPos,
        state: IBlockState,
        playerIn: EntityPlayer,
        hand: EnumHand,
        facing: EnumFacing,
        hitX: Float,
        hitY: Float,
        hitZ: Float
    ): Boolean {
        return if (worldIn.isRemote) true
        else {
//            val te = worldIn.getTileEntity(pos)
//            if (te is TileEntityTheEnchanter) playerIn.openGui(ModTheEnchanter, )
            true
        }
    }

    override fun onBlockPlacedBy(
        worldIn: World,
        pos: BlockPos,
        state: IBlockState,
        placer: EntityLivingBase,
        stack: ItemStack
    ) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack)
        if (stack.hasDisplayName()) {
//            val te = worldIn.getTileEntity(pos)
//            if (te is TileEntityTheEnchanter) te.customName = stack.displayName
        }
    }

    fun initModels() {
        ModelLoader.setCustomModelResourceLocation(itemBlock, 0, ModUtils.makeModelRL("$registryName"))
    }

//    override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? = TileEntityTheEnchanter()

    override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? {
        return null
    }

    //region Basic overrides
    override fun isFullCube(state: IBlockState) = false

    override fun isOpaqueCube(state: IBlockState) = false

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos) = aabb

    override fun getRenderType(state: IBlockState) = EnumBlockRenderType.MODEL

    override fun getBlockFaceShape(worldIn: IBlockAccess?, state: IBlockState?, pos: BlockPos?, face: EnumFacing) =
            if (face == EnumFacing.DOWN) BlockFaceShape.SOLID else BlockFaceShape.UNDEFINED
    //endregion
}
