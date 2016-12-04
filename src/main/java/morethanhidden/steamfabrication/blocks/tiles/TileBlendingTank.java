package morethanhidden.steamfabrication.blocks.tiles;

import morethanhidden.steamfabrication.api.ISFFluidTile;
import morethanhidden.steamfabrication.blocks.BlockBlendingTank;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileBlendingTank extends TileFluidHandler implements ITickable, ISFFluidTile {

    boolean active = false;
    int count = 0;

    public TileBlendingTank() {
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

    @Override
    public void update() {
        updateSteam();
    }

    public void updateSteam() {
        if (tank.getFluid() == null) {
            IFluidHandler lefttank = FluidUtil.getFluidHandler(this.worldObj, pos.add(0, 0, -1), EnumFacing.WEST);
            IFluidHandler righttank = FluidUtil.getFluidHandler(this.worldObj, pos.add(0, 0, 1), EnumFacing.EAST);

            if (lefttank != null && righttank != null) {
                FluidStack leftfluid = lefttank.drain(1000, false);
                FluidStack rightfluid = righttank.drain(1000, false);
                if (leftfluid != null && rightfluid != null) {
                    if (leftfluid.containsFluid(new FluidStack(FluidRegistry.getFluid("water"), 1000)) && rightfluid.containsFluid(new FluidStack(FluidRegistry.getFluid("lava"), 1000))) {
                        active = true;
                        count++;
                        worldObj.notifyBlockUpdate(pos, worldObj.getBlockState(pos), worldObj.getBlockState(pos).withProperty(BlockBlendingTank.ACTIVE, true), 0);

                        if (count > 45) {
                            lefttank.drain(leftfluid, true);
                            righttank.drain(rightfluid, true);
                            tank.fill(new FluidStack(FluidRegistry.getFluid("steam"), 1000), true);
                            active = false;
                            worldObj.notifyBlockUpdate(pos, worldObj.getBlockState(pos), worldObj.getBlockState(pos).withProperty(BlockBlendingTank.ACTIVE, false), 0);
                        }
                        return;
                    }
                }
            }
            count = 0;
        }
    }

    public boolean isActive(){
        return active;
    }

}
