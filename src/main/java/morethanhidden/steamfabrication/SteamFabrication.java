package morethanhidden.steamfabrication;

import morethanhidden.steamfabrication.network.SFSync;
import morethanhidden.steamfabrication.registry.BlockRegistry;
import morethanhidden.steamfabrication.registry.ItemRegistry;
import morethanhidden.steamfabrication.registry.SFFluidRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Mod(modid = SteamFabrication.MODID, version = SteamFabrication.VERSION)
public class SteamFabrication
{

    public static final String MODID = "steamfabrication";
    public static final String VERSION = "0.1a";

    static{
        //Enable Buckets
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.Instance(value = "steamfabrication")
    public static SteamFabrication instance;

    @SidedProxy(clientSide="morethanhidden.steamfabrication.Client.ClientProxy", serverSide="morethanhidden.steamfabrication.common")
    public static common proxy;

    //Creative tab for my mod
    public static CreativeTabs tabsteamfabrication = new CreativeTabs("steamfabrication") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.LAVA_BUCKET);
        }
    };
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        SFFluidRegistry.init();
        BlockRegistry.init();
        ItemRegistry.init();
        SFSync.init();

        proxy.registerRenderers();
    }

}
