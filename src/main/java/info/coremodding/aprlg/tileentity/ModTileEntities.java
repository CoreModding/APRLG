package info.coremodding.aprlg.tileentity;

import info.coremodding.aprlg.tileentity.TileEntityRPLG;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void regTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRPLG.class, "rplg");
	}
}
