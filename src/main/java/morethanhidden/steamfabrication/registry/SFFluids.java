package morethanhidden.steamfabrication.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class SFFluids {

    public static Fluid steam = new Fluid("steam", new ResourceLocation("steamfabrication:steam_still"), new ResourceLocation("steamfabrication:steam_flow")).setDensity(-1000).setGaseous(true);

    public static void init() {

        //Enable Buckets
        FluidRegistry.enableUniversalBucket();

        //Check if Steam is Already Registered
        if(!FluidRegistry.registerFluid(steam)) {
            steam = FluidRegistry.getFluid("steam");
        }

    }

}
