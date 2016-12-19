package morethanhidden.steamfabrication.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public interface IWrenchable {

    public void WrenchRightClick(EntityPlayer player, BlockPos pos, IBlockState state);
    public void WrenchSneakRightClick(EntityPlayer player, BlockPos pos, IBlockState state);

}
