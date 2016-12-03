package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.blocks.tiles.TileFluidChamber;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import javax.annotation.Nullable;

public class BlockFluidChamber extends BlockContainer{

	public BlockFluidChamber() {
		super(Material.GLASS);
		setCreativeTab(SteamFabrication.tabsteamfabrication);
        setUnlocalizedName("chamber");
		setRegistryName(new ResourceLocation(SteamFabrication.MODID, getUnlocalizedName().substring(5)));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ)) {
			return true;
		}

		TileFluidChamber tile = (TileFluidChamber) worldIn.getTileEntity(pos);

		FluidActionResult res = FluidUtil.tryEmptyContainer(playerIn.getHeldItem(hand), tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side), 1000, playerIn, true);
		if (res.isSuccess()){
			playerIn.setHeldItem(hand, res.getResult());
			return true;
		}

		res = FluidUtil.tryFillContainer(playerIn.getHeldItem(hand), tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side), 1000, playerIn, true);
		if (res.isSuccess()){
			playerIn.setHeldItem(hand, res.getResult());
			return true;
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return  BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileFluidChamber();
	}

}

