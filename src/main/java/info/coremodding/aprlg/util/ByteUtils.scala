package info.coremodding.aprlg.util

import scala.runtime.RichInt

object ByteUtils {

  def booleanArrayFromByte(x: Byte): Array[Boolean] = {
    val bs = Array.ofDim[Boolean](8)
    bs(0) = (((x - Byte.MinValue) & 0x001) != 0)
    bs(1) = (((x - Byte.MinValue) & 0x002) != 0)
    bs(2) = (((x - Byte.MinValue) & 0x004) != 0)
    bs(3) = (((x - Byte.MinValue) & 0x008) != 0)
    bs(4) = (((x - Byte.MinValue) & 0x016) != 0)
    bs(5) = (((x - Byte.MinValue) & 0x032) != 0)
    bs(6) = (((x - Byte.MinValue) & 0x064) != 0)
    bs(7) = (((x - Byte.MinValue) & 0x128) != 0)
    bs
  }
  
  def byteFromBooleanArray(x: Array[Boolean]): Byte = {
    
    var b : Int = 0
    for (i <- 0 until 8) {
      b = b << 0x1
      if (x(i)) {
        b |= 0x1
      }
    }
    b += Byte.MinValue
    b.toByte
  }
  
  def usignedByteArrayToHexString(x : Array[Byte]): String = {
    var byteString: String = ""
    for( n <- 0 to x.length - 1) {
      val currentByte: RichInt = (x(n) - Byte.MinValue)
      if(currentByte.toHexString.length() == 1) 
        byteString = byteString + "0"
      byteString = byteString + currentByte.toHexString
    }
    byteString
  }
  
  def usignedByteArrayToBinString(x : Array[Byte]): String = {
    var byteString: String = ""
    for( n <- 0 to x.length - 1) {
      val currentByte: RichInt = (x(n) - Byte.MinValue)
      var currentByteAsString = currentByte.toBinaryString
      while(currentByteAsString.length() < 8) {
        currentByteAsString = "0" + currentByteAsString
      }
      byteString = byteString + currentByteAsString
    }
    byteString
  }
}