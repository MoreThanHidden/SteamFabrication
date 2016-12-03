package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block{

	public BlockBase(String unlocalisedname) {
		super(Material.ROCK);
		setCreativeTab(SteamFabrication.tabsteamfabrication);
		setUnlocalizedName(unlocalisedname);
		setRegistryName(new ResourceLocation(SteamFabrication.MODID, getUnlocalizedName().substring(5)));
	}

}


