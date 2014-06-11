package info.coremodding.aprlg.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block rplg = new BlockPRLG();
	public static void regBlocks() {
		
		GameRegistry.registerBlock(rplg, "rplg");
	}
}
