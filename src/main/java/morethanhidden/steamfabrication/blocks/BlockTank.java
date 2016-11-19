package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTank extends Block{

	public BlockTank() {
		super(Material.ROCK);
		setCreativeTab(SteamFabrication.tabsteamfabrication);
        setUnlocalizedName("chamber");
	}
}


