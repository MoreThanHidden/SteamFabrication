package morethanhidden.steamfabrication.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IWrenchable {

    public void WrenchRightClick(EntityPlayer player, World worldIn, BlockPos pos, IBlockState state);
    public void WrenchSneakRightClick(EntityPlayer player, World worldIn, BlockPos pos, IBlockState state);

}
