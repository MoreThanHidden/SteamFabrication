package morethanhidden.steamfabrication.network;


import net.minecraft.entity.player.EntityPlayerMP;

public class SFSync {

    static SFNetworkWrap networkWrapper;
    static SFSync INSTANCE;

    public static void init() {
        networkWrapper = new SFNetworkWrap("steamfabrication");
        networkWrapper.registerPacketClient(FluidPacket.class);
        INSTANCE = new SFSync();
    }

    public static void sendTo(FluidPacket packet, EntityPlayerMP player) {
        networkWrapper.network.sendTo(packet, player);
    }

}
