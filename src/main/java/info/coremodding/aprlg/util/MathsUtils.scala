package info.coremodding.aprlg.util

object MathsUtils {
	def isStringHexadecimal(hexString : String): Boolean = {
	   val hexChars = (('a' to 'f') ++ ('A' to 'F') ++ ('0' to '9')).toSet
	   hexString.forall(hexChars.contains(_))
	}
	

}