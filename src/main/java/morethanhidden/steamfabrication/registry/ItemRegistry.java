package morethanhidden.steamfabrication.registry;

import morethanhidden.steamfabrication.items.wrench;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
    public static Item Wrench;

    public static void init(){
        Wrench = new wrench();
        registerItem(Wrench);
    }

    private static void registerItem(Item item) {
        GameRegistry.register(item);
    }

}
