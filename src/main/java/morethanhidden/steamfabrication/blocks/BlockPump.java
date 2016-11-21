package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockPump extends Block{

    public BlockPump() {
        super(Material.GLASS);
        setCreativeTab(SteamFabrication.tabsteamfabrication);
        setUnlocalizedName("pump");
        setRegistryName(new ResourceLocation(SteamFabrication.MODID, getUnlocalizedName().substring(5)));
    }
}
