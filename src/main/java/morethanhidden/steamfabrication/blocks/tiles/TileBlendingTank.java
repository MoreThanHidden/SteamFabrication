package morethanhidden.steamfabrication.blocks.tiles;

import morethanhidden.steamfabrication.blocks.BlockBlendingTank;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.TileFluidHandler;

public class TileBlendingTank extends TileFluidHandler implements ITickable{

    boolean active = false;
    int count = 0;

    public TileBlendingTank() {
    }

    @Override
    public void update() {
        updateSteam();
    }

    public void updateSteam(){
        IFluidHandler lefttank = FluidUtil.getFluidHandler(this.worldObj, pos.add(0, 0, -1), EnumFacing.WEST);
        IFluidHandler righttank= FluidUtil.getFluidHandler(this.worldObj, pos.add(0, 0, 1), EnumFacing.EAST);

        if (lefttank != null && righttank != null){
            FluidStack leftfluid = lefttank.drain(1000, false);
            FluidStack rightfluid = righttank.drain(1000, false);
            if(leftfluid != null && rightfluid != null) {
                if (leftfluid.containsFluid(new FluidStack(FluidRegistry.getFluid("water"), 1000)) && rightfluid.containsFluid(new FluidStack(FluidRegistry.getFluid("lava"), 1000))) {
                    active = true;
                    count++;
                    worldObj.notifyBlockUpdate(pos, worldObj.getBlockState(pos), worldObj.getBlockState(pos).withProperty(BlockBlendingTank.ACTIVE, true), 0);

                    if(count > 45) {
                        lefttank.drain(leftfluid, true).amount = 0;
                        righttank.drain(rightfluid, true).amount = 0;
                        active = false;
                        worldObj.notifyBlockUpdate(pos, worldObj.getBlockState(pos), worldObj.getBlockState(pos).withProperty(BlockBlendingTank.ACTIVE, false), 0);
                    }
                    return;
                }
            }
        }
        count = 0;
    }

    public boolean isActive(){
        return active;
    }

}
