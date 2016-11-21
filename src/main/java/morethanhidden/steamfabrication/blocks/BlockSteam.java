package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockSteam extends BlockFluidClassic {

    public BlockSteam(Fluid fluid) {
        super(fluid, new MaterialLiquid(MapColor.GRAY));
        setUnlocalizedName("steam");
        setRegistryName(SteamFabrication.MODID, "fluid");

    }

}
