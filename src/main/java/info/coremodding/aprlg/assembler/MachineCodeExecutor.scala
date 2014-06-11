package info.coremodding.aprlg.assembler

import info.coremodding.aprlg.tileentity.TileEntityRPLG
import info.coremodding.aprlg.util.BlockUtils

object MachineCodeExecutor {
	def runMachineCode(rplg: TileEntityRPLG) {
	  val machineCode = rplg.machineCode
	  var stack = rplg.stack
	  var stackPos = rplg.stackPos
	  val world = rplg.getWorldObj()
	  val x = rplg.xCoord
	  val y = rplg.yCoord
	  val z = rplg.zCoord
	  val metaData = rplg.getBlockMetadata()
	  val redstoneDown =  world.isBlockProvidingPowerTo(x, y - 1, z, 0);
	  val redstoneUp =  world.isBlockProvidingPowerTo(x, y + 1, z, 1);
	  val redstoneFront =  BlockUtils.isBeingPoweredByBlockToSide(
	      BlockUtils.getDirectionFromSideAndRotation(
	          BlockUtils.front, 
	          metaData),
	          world,
	          x, y, z)
	   val redstoneRight =  BlockUtils.isBeingPoweredByBlockToSide(
	      BlockUtils.getDirectionFromSideAndRotation(
	          BlockUtils.right, 
	          metaData),
	          world,
	          x, y, z)
	    val redstoneBack =  BlockUtils.isBeingPoweredByBlockToSide(
	      BlockUtils.getDirectionFromSideAndRotation(
	          BlockUtils.back, 
	          metaData),
	          world,
	          x, y, z)
	     val redstoneLeft =  BlockUtils.isBeingPoweredByBlockToSide(
	      BlockUtils.getDirectionFromSideAndRotation(
	          BlockUtils.left, 
	          metaData),
	          world,
	          x, y, z)
         
                    
    
	}
}