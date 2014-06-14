/**
 * 
 */
package info.coremodding.aprlg.block;

import info.coremodding.aprlg.references.Reference;
import info.coremodding.aprlg.tileentity.TileEntityRPLG;
import info.coremodding.aprlg.util.BlockUtils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author ethan
 *
 */
public class BlockPRLG extends BlockContainer {
	
	private IIcon[] textures;
	
	public BlockPRLG() {
		super(Material.iron);
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
        //++yRotation;
        yRotation %= 4;
        
        world.setBlockMetadataWithNotify(x, y, z, yRotation, 2);

        
    }
	
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.textures = new IIcon[5];

        for (int i = 0; i < this.textures.length; ++i)
        {
            //this.textures[i] = iconRegister.registerIcon(Reference.Mod.ID +":textures/blocks/prlg" + "_" + i);
        	this.textures[i] = iconRegister.registerIcon(Reference.Mod.ID +":"+ "prlg" + "_" + i);
        }
    }
	
	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int side, int meta)
	 {	
		int fourPointSide = BlockUtils.sixPointDirToFourPointDir(side);
		
		if(fourPointSide == BlockUtils.unknown()) {
			return textures[4];
		} else {
			return textures[BlockUtils.getSideFromDirectionAndRotation(fourPointSide, meta)];
		}
		/* if(BlockUtils.sixPointDirToFourPointDir(side) == meta) {
			 return Blocks.redstone_block.getIcon(0, 0);
		 } else {
			 return Blocks.quartz_block.getIcon(0, 0);
		 }*/
	 }
	 
	 @Override
	 public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side)
	 {
		 int fourPointSide = BlockUtils.sixPointDirToFourPointDir(side);
		 
		/*if(BlockUtils.getSideFromDirectionAndRotation(fourPointSide, blockAccess.getBlockMetadata(x, y, z)) == BlockUtils.back()) {
			return 15;
		}*/
		 return 0;
		 
	 }
	 
	 @Override
	 public boolean canProvidePower()
	 {
	      return true;
	 }
	 
	 @Override
	 public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		 return true;
	 }
	 


}
