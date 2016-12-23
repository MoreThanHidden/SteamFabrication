package morethanhidden.steamfabrication.Client;

import morethanhidden.MTHCore.util.BlockModelResolver;
import morethanhidden.MTHCore.util.ModelHelper;
import morethanhidden.steamfabrication.registry.BlockRegistry;
import morethanhidden.steamfabrication.registry.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class ItemModelRegistry {

    public static void init() {
        //Blocks
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockBlendingTank), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockFluidChamber), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockPipe), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockCopperOre), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockEngine), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockTurbine), 0);

        ModelHelper.registerItemModel(ItemRegistry.Wrench, 0);

        MinecraftForge.EVENT_BUS.register(new BlockModelResolver());
    }
}