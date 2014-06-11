package info.coremodding.aprlg.assembler

import java.util.ArrayList
import info.coremodding.aprlg.util.MathsUtils
import scala.collection.mutable.ListBuffer

object AssemblerUtils {

	def isStringValidMachineCode(machineCode: String): Boolean = {
			val machineCodeParts: Array[String] = machineCode.split("\n| ")
					for(hexCodePart <- machineCodeParts) {
					  
					  
						if( hexCodePart != "" &&  hexCodePart != "\n") {
						  
							if(hexCodePart.length() != 2)
								return false
								
							
							if(!MathsUtils.isStringHexadecimal(hexCodePart))
								return false
								
							
							val hexCode: Int = Integer.parseInt(hexCodePart, 16);
							
							if(!(hexCode + Byte.MinValue).isValidByte)
								return false
							
						}
					}
		return true
	}

	def convertStringIntoMachineCode(machineCode: String): Array[Byte] = {

		val machineCodeParts: Array[String] = machineCode.split("\n| ")
		val machineCodeArray: ListBuffer[Byte] = ListBuffer[Byte]()

		for(hexCodePart <- machineCodeParts) {
			if( hexCodePart != "") {
				val hexCode: Int = Integer.parseInt(hexCodePart, 16);
				machineCodeArray += (hexCode + Byte.MinValue).toByte
				System.out.println(hexCode)
			}
		}
		
		machineCodeArray.toArray
	}
}