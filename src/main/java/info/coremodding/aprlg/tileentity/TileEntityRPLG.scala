package info.coremodding.aprlg.tileentity

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import info.coremodding.aprlg.util.ByteUtils
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.EntityPlayer
import info.coremodding.aprlg.util.BookUtils
import info.coremodding.aprlg.assembler.AssemblerUtils
import net.minecraft.util.IChatComponent
import net.minecraft.util.ChatComponentText

class TileEntityRPLG extends TileEntity {

  var machineCode: Array[Byte] = new Array[Byte](0)

  var stack: Array[Boolean] = new Array[Boolean](8)

  var stackPos: Byte = 0

  override def readFromNBT(nbt: NBTTagCompound) {
	super.readFromNBT(nbt);
    this.machineCode = nbt.getByteArray("machineCode")
    this.stack = ByteUtils.booleanArrayFromByte(nbt.getByte("stack"))
    this.stackPos = nbt.getByte("stackPos")
 }

  override def writeToNBT(nbt: NBTTagCompound) {
    nbt.setByteArray("machineCode", machineCode)
    nbt.setByte("stack", ByteUtils.byteFromBooleanArray(stack))
    nbt.setByte("stackPos", stackPos)
    
  }
  
  def loadBook (book: ItemStack, player: EntityPlayer) {
	  val machineCodeString : String = BookUtils.getBookPagesAsSingleString(book)
	  val isMachineCode = AssemblerUtils.isStringValidMachineCode(machineCodeString)
	  
	  if(isMachineCode) {
	    machineCode = AssemblerUtils.convertStringIntoMachineCode(machineCodeString)
	    player.addChatMessage(new ChatComponentText("Is machine code. Loaded into gate. Code: " + ByteUtils.usignedByteArrayToHexString(machineCode)))
	  } else {
	    player.addChatMessage(new ChatComponentText("Not Machine Code"))
	  }
  }
  
  def debug (player: EntityPlayer) {
	  player.addChatMessage(new ChatComponentText("Code: " + ByteUtils.usignedByteArrayToHexString(machineCode)))
	  player.addChatMessage(new ChatComponentText("Stack: " + ByteUtils.usignedByteArrayToBinString(Array(ByteUtils.byteFromBooleanArray(stack)) ) ) )
	  player.addChatMessage(new ChatComponentText("StackPos: " + stackPos))
	
  }

}