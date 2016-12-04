package morethanhidden.steamfabrication.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class SFNetworkWrap {

    public final SimpleNetworkWrapper network;
    protected final SFPacketHandler handler;
    private int id = 0;

    public SFNetworkWrap(String channelName) {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
        handler = new SFPacketHandler();
    }

    public void registerPacketClient(Class<? extends FluidPacket> packetClazz) {
        registerPacket(packetClazz, Side.CLIENT);
    }

    private void registerPacket(Class<? extends FluidPacket> packetClazz, Side side) {
        network.registerMessage(handler, packetClazz, id++, side);
    }

    public static void sendToClients(WorldServer world, BlockPos pos, FluidPacket packet) {
        Chunk chunk = world.getChunkFromBlockCoords(pos);
        for(EntityPlayer player : world.playerEntities) {
            // only send to relevant players
            if(!(player instanceof EntityPlayerMP)) {
                continue;
            }
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            if(world.getPlayerChunkMap().isPlayerWatchingChunk(playerMP, chunk.xPosition, chunk.zPosition)) {
                SFSync.sendTo(packet, playerMP);
            }
        }
    }

}
