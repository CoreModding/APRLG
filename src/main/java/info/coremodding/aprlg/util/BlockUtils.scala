package info.coremodding.aprlg.util

import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection

object BlockUtils {
	val facingZP = 0
	val facingXN = 1
	val facingZN = 2
	val facingXP = 3
	
	val front = 0
	val right = 1
	val back = 2
	val left = 3
	
	val ZP = 0
	val XN = 1
	val ZN = 2
	val XP = 3
	
	val unknown = -1;
	
	def getDirectionFromSideAndRotation(side: Int, rotation: Int): Int = {
		return	(side + rotation) % 4
	}
	
	def getSideFromDirectionAndRotation(direction: Int, rotation: Int): Int = {
		return	(4 + rotation - direction) % 4
	}
	
	def isBeingPoweredByBlockToSide(side: Int, world: World, x: Int, y: Int, z: Int): Int = {
	  side match {
	    case ZP => world.isBlockProvidingPowerTo(x, y, z + 1, 3);
	    case ZN => world.isBlockProvidingPowerTo(x, y, z - 1, 2);
	    case XP => world.isBlockProvidingPowerTo(x, y, z + 1, 5);
	    case XN => world.isBlockProvidingPowerTo(x, y, z - 1, 4);
	  } 
	}
	
	def sixPointDirToFourPointDir(sideCodeSix: Int): Int = {
	  val dir: ForgeDirection  = ForgeDirection.getOrientation(sideCodeSix)
	  dir match {
	  	case ForgeDirection.SOUTH => ZP
	  	case ForgeDirection.WEST => XN
	  	case ForgeDirection.NORTH => ZN
	  	case ForgeDirection.EAST => XP
	  	case _ => unknown}
	}
	
}
