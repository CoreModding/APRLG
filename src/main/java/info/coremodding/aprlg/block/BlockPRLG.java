/**
 * 
 */
package info.coremodding.aprlg.block;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.coremodding.aprlg.tileentity.TileEntityRPLG;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

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
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int yRotation = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        ++yRotation;
        yRotation %= 4;

        if (yRotation == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (yRotation == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (yRotation == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        }

        if (yRotation == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        }
    }
	
	/* @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int side, int meta)
	    {
		 
	    }*/

}
