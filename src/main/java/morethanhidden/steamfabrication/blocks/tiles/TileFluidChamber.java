package morethanhidden.steamfabrication.blocks.tiles;

import morethanhidden.steamfabrication.api.ISFFluidTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileFluidChamber extends TileFluidHandler implements ISFFluidTile {

    public TileFluidChamber() {
        this.tank = new SFFluidTank(1000, this);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        tank.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag = super.writeToNBT(tag);
        tank.writeToNBT(tag);
        return tag;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateFluid(FluidStack fluid) {
        tank.setFluid(fluid);
    }

}
