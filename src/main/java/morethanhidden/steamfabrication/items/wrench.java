package morethanhidden.steamfabrication.items;

import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.api.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class wrench extends ItemTool{

    public wrench(Set<Block> blocks) {
        super(ToolMaterial.IRON, blocks);
        setUnlocalizedName("wrench");
        setRegistryName(SteamFabrication.MODID, "wrench");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Block block = worldIn.getBlockState(pos).getBlock();
        if (block instanceof IWrenchable){
            if (player.isSneaking()){
                ((IWrenchable)block).WrenchSneakRightClick(player, worldIn, pos, worldIn.getBlockState(pos));
                return EnumActionResult.SUCCESS;
            }
            ((IWrenchable)block).WrenchRightClick(player, worldIn, pos, worldIn.getBlockState(pos));
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;

    }
}
