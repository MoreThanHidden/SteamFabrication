package morethanhidden.steamfabrication.registry;

import morethanhidden.steamfabrication.items.wrench;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;
import java.util.Set;

public class ItemRegistry {
    public static Item Wrench;

    public static void init(){
        Set<Block> blocks = new HashSet<Block>();
        blocks.add(BlockRegistry.blockPipe);

        Wrench = new wrench(blocks);
        registerItem(Wrench);

    }

    private static void registerItem(Item item) {
        GameRegistry.register(item);
    }

}
