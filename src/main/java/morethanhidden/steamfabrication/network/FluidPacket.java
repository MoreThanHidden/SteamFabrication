package morethanhidden.steamfabrication.network;

import io.netty.buffer.ByteBuf;
import morethanhidden.steamfabrication.api.ISFFluidTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class FluidPacket implements IMessage {

    public BlockPos pos;
    public FluidStack fluid;

    public FluidPacket() {
    }

    public FluidPacket(BlockPos pos, FluidStack fluid) {
        this.pos = pos;
        this.fluid = fluid;
    }

    public final IMessage handleClient(final NetHandlerPlayClient netHandler) {
        FMLCommonHandler.instance().getWorldThread(netHandler).addScheduledTask(new Runnable() {
            @Override
            public void run() {
                handleClientSafe(netHandler);
            }
        });
        return null;
    }

    public void handleClientSafe(NetHandlerPlayClient netHandler) {
        TileEntity te = Minecraft.getMinecraft().world.getTileEntity(pos);
        if(te instanceof ISFFluidTile) {
            ((ISFFluidTile) te).updateFluid(fluid);
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        pos = new BlockPos(x, y, z);
        NBTTagCompound tag = ByteBufUtils.readTag(buf);
        fluid = FluidStack.loadFluidStackFromNBT(tag);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(pos.getX());
        buf.writeInt(pos.getY());
        buf.writeInt(pos.getZ());
        NBTTagCompound tag = new NBTTagCompound();
        if(fluid != null) {
            fluid.writeToNBT(tag);
        }
        ByteBufUtils.writeTag(buf, tag);
    }
}
