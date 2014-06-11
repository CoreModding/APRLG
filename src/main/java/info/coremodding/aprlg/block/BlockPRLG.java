/**
 * 
 */
package info.coremodding.aprlg.block;

import info.coremodding.aprlg.tileentity.TileEntityRPLG;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author ethan
 *
 */
public class BlockPRLG extends BlockContainer {

	protected BlockPRLG() {
		super(Material.iron);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityRPLG();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xOffset, float yOffset, float zOffset)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			if(player.getHeldItem()!= null) {
				if(player.getHeldItem().getItem() == Items.written_book) {
					((TileEntityRPLG)world.getTileEntity(x, y, z)).loadBook(player.getHeldItem(), player);
					return true;
				} else if(player.getHeldItem().getItem() == Items.string) {
					((TileEntityRPLG)world.getTileEntity(x, y, z)).debug(player);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

}
