package morethanhidden.steamfabrication.blocks;

import morethanhidden.MTHCore.blocks.BlockBaseRotatable;
import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.api.IWrenchable;
import morethanhidden.steamfabrication.utils.WrenchUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class BlockPump extends BlockBaseRotatable implements IWrenchable{

    public BlockPump() {
        super(SteamFabrication.MODID, "pump");
        setCreativeTab(SteamFabrication.tabsteamfabrication);
    }

    @Override
    public void WrenchRightClick(EntityPlayer player, BlockPos pos, IBlockState state) {
        WrenchUtils.standardWrenchRightClick(player, this, pos, state);
    }

    @Override
    public void WrenchSneakRightClick(EntityPlayer player, BlockPos pos, IBlockState state) {
        WrenchUtils.standardWrenchSneakRightClick(player, this, pos, state);
    }
}
