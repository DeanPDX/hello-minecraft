package hellominecraft.wimpytntmod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.util.BlockPos;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Items;
import net.minecraft.client.Minecraft;


public class WimpyTNTBlock extends Block 
{
	private final String name = "wimpyTNT";

    public WimpyTNTBlock () 
    {
            super(Material.tnt);
			setHardness(0.1F);
            setUnlocalizedName(name);
            setCreativeTab(CreativeTabs.tabBlock);
    }

	public String getName()
	{
		return name;
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (playerIn.getCurrentEquippedItem() != null)
        {
            Item item = playerIn.getCurrentEquippedItem().getItem();

            if (item == Items.flint_and_steel || item == Items.fire_charge)
            {
				float f = .5F;

				World worldObj = Minecraft.getMinecraft().theWorld;
				
				worldObj.createExplosion(null, pos.getX(),
					pos.getY(), pos.getZ(), f, true);

				worldIn.setBlockToAir(pos);
                return true;
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

}
