package morethanhidden.steamfabrication.registry;

import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.blocks.BlockPipe;
import morethanhidden.steamfabrication.blocks.BlockSteam;
import morethanhidden.steamfabrication.blocks.BlockTank;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    public static Block blockChamber = new BlockTank();
    public static Block blockPipe = new BlockPipe();
    public static Block blockSteam = new BlockSteam(SFFluids.steam, Material.WATER);

    public static void init() {
        blockChamber.setRegistryName(new ResourceLocation(SteamFabrication.MODID, "chamber"));
        blockPipe.setRegistryName(new ResourceLocation(SteamFabrication.MODID, "fluid_pipe"));
        blockSteam.setRegistryName(new ResourceLocation(SteamFabrication.MODID, "steam"));
        registerBlock(blockChamber);
        registerBlock(blockPipe);
        registerBlock(blockSteam);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}