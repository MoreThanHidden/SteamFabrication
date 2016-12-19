package morethanhidden.steamfabrication.utils;

import morethanhidden.MTHCore.api.IRotatable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class WrenchUtils {

    public static void standardWrenchRightClick(EntityPlayer player, IRotatable block, BlockPos pos, IBlockState state){
        block.setFacing(player.world, pos, state, block.getFacing(state).rotateAround(EnumFacing.Axis.Y));
    }

    public static void standardWrenchSneakRightClick(EntityPlayer player, Block block, BlockPos pos, IBlockState state){
        block.breakBlock(player.world, pos, player.world.getBlockState(pos));
    }

}
