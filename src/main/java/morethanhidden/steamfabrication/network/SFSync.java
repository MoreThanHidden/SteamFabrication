package morethanhidden.steamfabrication.network;

import morethanhidden.MTHCore.network.NetworkWrap;
import morethanhidden.MTHCore.network.FluidMessage;

public class SFSync {

    static NetworkWrap networkWrapper;
    static SFSync INSTANCE;

    public static void init() {
        networkWrapper = new NetworkWrap("steamfabrication");
        networkWrapper.registerPacketClient(FluidMessage.class);
        INSTANCE = new SFSync();
    }

}
