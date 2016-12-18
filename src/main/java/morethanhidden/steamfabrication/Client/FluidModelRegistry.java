package morethanhidden.steamfabrication.Client;

import morethanhidden.MTHCore.util.FluidStateMapper;
import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.registry.SFFluidRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

public class FluidModelRegistry {

    public static void init() {
        registerFluidModels(SFFluidRegistry.steam);
    }

    public static void registerFluidModels(Fluid fluid) {
        if (fluid == null) {
            return;
        }

        Block block = fluid.getBlock();
        if (block != null) {
            Item item = Item.getItemFromBlock(block);
            FluidStateMapper mapper = new FluidStateMapper(fluid, SteamFabrication.MODID, "fluid");

            if (item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }

            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }
}