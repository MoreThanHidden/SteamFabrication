package morethanhidden.steamfabrication.registry;

import morethanhidden.steamfabrication.blocks.BlockBlendingTank;
import morethanhidden.steamfabrication.blocks.BlockPipe;
import morethanhidden.steamfabrication.blocks.BlockSteam;
import morethanhidden.steamfabrication.blocks.BlockTank;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    public static Block blockChamber = new BlockTank();
    public static Block blockBlendingTank = new BlockBlendingTank();
    public static Block blockPipe = new BlockPipe();
    public static Block blockSteam = new BlockSteam(SFFluids.steam);

    public static void init() {
        registerBlock(blockChamber);
        registerBlock(blockPipe);
        registerBlock(blockBlendingTank);
        registerBlock(blockSteam);
        FluidRegistry.addBucketForFluid(SFFluids.steam);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}