package morethanhidden.steamfabrication.items;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class wrench extends ItemTool{

    public wrench(Set<Block> blocks) {
        super(ToolMaterial.IRON, blocks);
        setUnlocalizedName("wrench");
        setRegistryName(SteamFabrication.MODID, "wrench");
    }

}
