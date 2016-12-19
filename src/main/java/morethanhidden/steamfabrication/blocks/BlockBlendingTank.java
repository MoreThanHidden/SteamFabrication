package morethanhidden.steamfabrication.blocks;

import morethanhidden.MTHCore.api.IRotatable;
import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.api.IWrenchable;
import morethanhidden.steamfabrication.blocks.tiles.TileBlendingTank;
import morethanhidden.steamfabrication.utils.WrenchUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBlendingTank extends BlockContainer implements IWrenchable, IRotatable{

	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockBlendingTank() {
		super(Material.GLASS);
		setCreativeTab(SteamFabrication.tabsteamfabrication);
        setUnlocalizedName("blending_tank");
		setRegistryName(new ResourceLocation(SteamFabrication.MODID, getUnlocalizedName().substring(5)));
		this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, false).withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return  BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, ACTIVE, FACING);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).ordinal();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		setFacing(worldIn, pos, state, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return state.withProperty(ACTIVE, isActive(worldIn, pos));
	}

	public final boolean isActive(IBlockAccess world, BlockPos pos)	{
		TileBlendingTank tile = (TileBlendingTank)world.getTileEntity(pos);
		return tile.isActive();
	}

	@Override
	public Block setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileBlendingTank();
	}

	@Override
	public void WrenchRightClick(EntityPlayer player, BlockPos pos, IBlockState state) {
		WrenchUtils.standardWrenchRightClick(player, this, pos, state);
	}

	@Override
	public void WrenchSneakRightClick(EntityPlayer player, BlockPos pos, IBlockState state) {
		WrenchUtils.standardWrenchSneakRightClick(player, this, pos, state);
	}

	@Override
	public EnumFacing getFacing(IBlockState state) {
		return state.getValue(FACING);
	}

	@Override
	public boolean setFacing(World worldIn, BlockPos pos, IBlockState state, EnumFacing facing) {
		return worldIn.setBlockState(pos, state.withProperty(FACING, facing), 2);
	}

	@Override
	public Boolean ishorizontal() {
		return true;
	}
}


