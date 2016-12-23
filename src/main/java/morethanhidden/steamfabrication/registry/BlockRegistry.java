package morethanhidden.steamfabrication.registry;

import morethanhidden.MTHCore.blocks.BlockBase;
import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.blocks.*;
import morethanhidden.steamfabrication.blocks.tiles.TileBlendingTank;
import morethanhidden.steamfabrication.blocks.tiles.TileFluidChamber;
import morethanhidden.steamfabrication.blocks.tiles.TilePipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    public static Block blockFluidChamber = new BlockFluidChamber();
    public static Block blockBlendingTank = new BlockBlendingTank();
    public static Block blockPipe = new BlockPipe();
    public static Block blockCopperOre = new BlockBase(SteamFabrication.MODID, "ore_copper");
    public static Block blockSteam = new BlockSteam(SFFluidRegistry.steam);
    public static Block blockEngine = new BlockEngine();
    public static Block blockTurbine = new BlockTurbine();

    public static void init() {
        GameRegistry.registerTileEntity(TileFluidChamber.class, "fluid_chamber");
        GameRegistry.registerTileEntity(TilePipe.class, "pipe");
        GameRegistry.registerTileEntity(TileBlendingTank.class, "blending_tank");

        registerBlock(blockFluidChamber);
        registerBlock(blockPipe);
        registerBlock(blockBlendingTank);
        registerBlock(blockSteam);
        registerBlock(blockCopperOre);
        registerBlock(blockEngine);
        registerBlock(blockTurbine);

        FluidRegistry.addBucketForFluid(SFFluidRegistry.steam);
    }

    private static void registerBlock(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}