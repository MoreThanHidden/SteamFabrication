package morethanhidden.steamfabrication.utils;

import morethanhidden.MTHCore.api.IRotatable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WrenchUtils {

    public static void standardWrenchRightClick(World worldIn, IRotatable block, BlockPos pos, IBlockState state){
        block.setFacing(worldIn, pos, state, block.getFacing(state).rotateAround(EnumFacing.Axis.Y));
    }

    public static void standardWrenchSneakRightClick(World worldIn, Block block, BlockPos pos, IBlockState state){
        block.dropBlockAsItem(worldIn, pos, state, 1);
        worldIn.setBlockToAir(pos);
    }

}
