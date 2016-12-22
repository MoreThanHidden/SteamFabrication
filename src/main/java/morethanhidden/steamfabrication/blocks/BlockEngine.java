package morethanhidden.steamfabrication.blocks;

import morethanhidden.MTHCore.blocks.BlockBaseRotatable;
import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.api.IWrenchable;
import morethanhidden.steamfabrication.utils.WrenchUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEngine extends BlockBaseRotatable implements IWrenchable{

    public BlockEngine() {
        super(SteamFabrication.MODID, "engine");
        setCreativeTab(SteamFabrication.tabsteamfabrication);
    }

    @Override
    public void WrenchRightClick(EntityPlayer player, World worldIn, BlockPos pos, IBlockState state) {
        WrenchUtils.standardWrenchRightClick(worldIn, this, pos, state);
    }

    @Override
    public void WrenchSneakRightClick(EntityPlayer player, World worldIn, BlockPos pos, IBlockState state) {
        WrenchUtils.standardWrenchSneakRightClick(worldIn, this, pos, state);
    }
}
