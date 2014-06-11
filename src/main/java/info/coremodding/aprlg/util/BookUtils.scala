package info.coremodding.aprlg.util

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagList
import net.minecraft.nbt.NBTTagCompound

object BookUtils {
	def getBookPages(bookItemStack: ItemStack): Array[String] = {
	  if(bookItemStack.getTagCompound() == null) {
	    bookItemStack.setTagCompound(new NBTTagCompound())
	  }
			var pagesNBT: NBTTagList = bookItemStack.getTagCompound().getTagList("pages", 8)
			var pageCount: Int = pagesNBT.tagCount()
			val pages = new Array[String](pageCount)
			for( pos <- 0 to pageCount - 1) {
				pages(pos) = pagesNBT.getStringTagAt(pos);
			}
			pages
	}
	
	def getBookPagesAsSingleString(bookItemStack: ItemStack): String = {
	  getBookPages(bookItemStack).mkString(" ");
	}
}