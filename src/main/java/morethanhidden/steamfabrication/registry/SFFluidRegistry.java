package morethanhidden.steamfabrication.registry;

import morethanhidden.steamfabrication.SteamFabrication;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class SFFluidRegistry {

    public static Fluid steam = new Fluid("steam", new ResourceLocation(SteamFabrication.MODID, "blocks/steam_still"), new ResourceLocation(SteamFabrication.MODID, "blocks/steam_flow")).setDensity(-1000).setGaseous(true);

    public static void init() {

        //Check if Steam is Already Registered
        if(!FluidRegistry.registerFluid(steam)) {
            steam = FluidRegistry.getFluid("steam");
        }

    }

}
