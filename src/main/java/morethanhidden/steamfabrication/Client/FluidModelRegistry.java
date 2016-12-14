package morethanhidden.steamfabrication.Client;

import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.registry.SFFluidRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.Nonnull;

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
            FluidStateMapper mapper = new FluidStateMapper(fluid);

            if (item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }

            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

        public final Fluid fluid;
        public final ModelResourceLocation location;

        public FluidStateMapper(Fluid fluid) {
            this.fluid = fluid;
            this.location = new ModelResourceLocation(new ResourceLocation(SteamFabrication.MODID, "fluid"), fluid.getName());
        }

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            return location;
        }

        @Nonnull
        @Override
        public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
            return location;
        }
    }
}