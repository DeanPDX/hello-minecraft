package hellominecraft.wimpytntmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

}
