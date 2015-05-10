package hellominecraft.wimpytntmod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.client.resources.model.ModelResourceLocation;


@Mod(modid = WimpyTNTMod.MODID, name = WimpyTNTMod.NAME, version = WimpyTNTMod.VERSION)
public class WimpyTNTMod
{
    public static final String MODID = "WimpyTNT";
    public static final String VERSION = "1.0";
	public static final String NAME = "Wimpy TNT Mod";
    
	public static Block wimpyTNT;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		wimpyTNT = new WimpyTNTBlock();
		GameRegistry.registerBlock(wimpyTNT, "wimpyTNT");

		//register renders
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		
    		//blocks
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(wimpyTNT), 0, new ModelResourceLocation(WimpyTNTMod.MODID + ":" + ((WimpyTNTBlock)wimpyTNT).getName(), "inventory"));
    	}

    }
}
