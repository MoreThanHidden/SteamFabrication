package morethanhidden.steamfabrication.api;

import net.minecraft.entity.player.EntityPlayer;

public interface IWrenchable {

    public void WrenchRightClick(EntityPlayer player);
    public void WrenchSneakRightClick(EntityPlayer player);

}
