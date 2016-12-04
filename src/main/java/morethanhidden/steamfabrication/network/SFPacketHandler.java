package morethanhidden.steamfabrication.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SFPacketHandler implements IMessageHandler<FluidPacket, IMessage> {

    @Override
    public IMessage onMessage(FluidPacket message, MessageContext ctx) {
        if (ctx.side == Side.CLIENT){
            return message.handleClient(ctx.getClientHandler());
        }
        //havent needed server packets yet
        return null;
    }

}
