package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockSteam extends BlockFluidClassic{


        public BlockSteam(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(SteamFabrication.tabsteamfabrication);
                setLightLevel(0.625F);
                setUnlocalizedName("blocksteam");
        }
        
        @Override
        public boolean canDisplace(IBlockAccess world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().isAssociatedBlock(world.getBlockState(pos).getBlock())) return false;
                return super.canDisplace(world, pos);
        }
        
        @Override
        public boolean displaceIfPossible(World world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().isAssociatedBlock(world.getBlockState(pos).getBlock())) return false;
                return super.displaceIfPossible(world, pos);
        }
}
