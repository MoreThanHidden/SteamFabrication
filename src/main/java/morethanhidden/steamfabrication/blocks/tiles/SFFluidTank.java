package morethanhidden.steamfabrication.blocks.tiles;

import morethanhidden.steamfabrication.network.FluidPacket;
import morethanhidden.steamfabrication.network.SFNetworkWrap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class SFFluidTank extends FluidTank {

    private final TileEntity parent;

    public SFFluidTank(int capacity, TileEntity parent) {
        super(capacity);
        this.parent = parent;
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        int amount = super.fill(resource, doFill);
        if(amount > 0 && doFill) {
            sendUpdate(amount);
        }
        return amount;
    }

    @Override
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        FluidStack fluid = super.drain(resource, doDrain);
        if(fluid != null && doDrain) {
            sendUpdate(-fluid.amount);
        }
        return fluid;
    }

    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        FluidStack fluid = super.drain(maxDrain, doDrain);
        if(fluid != null && doDrain) {
            sendUpdate(-fluid.amount);
        }
        return fluid;
    }

    protected void sendUpdate(int amount) {
        if (amount != 0) {
            World world = parent.getWorld();
            if (!world.isRemote && world instanceof WorldServer) {
                SFNetworkWrap.sendToClients((WorldServer) world, parent.getPos(), new FluidPacket(parent.getPos(), this.getFluid()));
            }
        }
    }
}
