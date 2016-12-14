package morethanhidden.steamfabrication.Client;

import morethanhidden.steamfabrication.registry.BlockRegistry;
import morethanhidden.MTHCore.util.BlockModelResolver;
import morethanhidden.MTHCore.util.ModelHelper;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class ItemModelRegistry {

    public static void init() {
        //Blocks
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockBlendingTank), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockFluidChamber), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockPipe), 0);
        ModelHelper.registerItemModel(Item.getItemFromBlock(BlockRegistry.blockCopperOre), 0);

        MinecraftForge.EVENT_BUS.register(new BlockModelResolver());
    }
}