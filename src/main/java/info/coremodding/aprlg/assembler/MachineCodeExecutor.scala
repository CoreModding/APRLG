package info.coremodding.aprlg.assembler

import info.coremodding.aprlg.tileentity.TileEntityRPLG

object MachineCodeExecutor {
	def runMachineCode(rplg: TileEntityRPLG) {
	  val machineCode = rplg.machineCode
	  var stack = rplg.stack
	  var stackPos = rplg.stackPos
	  val world = rplg.getWorldObj()
	  val x = rplg.xCoord
	  val y = rplg.yCoord
	  val z = rplg.zCoord
	  val redstoneDown =  world.isBlockProvidingPowerTo(x, y - 1, z, 0);
	  val redstoneUp =  world.isBlockProvidingPowerTo(x, y + 1, z, 1);
	  val redstoneZN =  world.isBlockProvidingPowerTo(x, y, z - 1, 2);
	  val redstoneZP =  world.isBlockProvidingPowerTo(x, y, z + 1, 3);
	  val redstoneXN =  world.isBlockProvidingPowerTo(x - 1, y, z, 4);
	  val redstoneXP =  world.isBlockProvidingPowerTo(x + 1, y, z, 5);
         
                    
    
	}
}