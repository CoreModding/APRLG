package info.coremodding.aprlg;

import info.coremodding.aprlg.block.ModBlocks;
import info.coremodding.aprlg.references.Reference;
import info.coremodding.aprlg.tileentity.ModTileEntities;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.Mod.ID , name = Reference.Mod.NAME, version = Reference.Mod.VERSION)
public class APRLG {
	
	@Instance(Reference.Mod.ID)
	public static APRLG instance;
	
	@EventHandler
	public void preInitialization(FMLPreInitializationEvent preEvent) {
		ModBlocks.regBlocks();
		ModTileEntities.regTileEntities();
	}
	
	@EventHandler
	public void initialization(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInitialization(FMLPostInitializationEvent postEvent) {
		
	}
}
