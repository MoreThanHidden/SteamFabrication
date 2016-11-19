package morethanhidden.steamfabrication.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class SFFluids {

    public static Fluid steam = new Fluid("steam", new ResourceLocation("steamfabrication:fluidsteam_still"), new ResourceLocation("steamfabrication:fluidsteam_flowing"));

    public static void init() {

        FluidRegistry.registerFluid(steam);
        FluidRegistry.addBucketForFluid(steam);

    }

}
