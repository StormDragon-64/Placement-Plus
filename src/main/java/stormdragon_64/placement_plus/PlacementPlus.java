package stormdragon_64.placement_plus;

import net.minecraft.client.MinecraftClient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PlacementPlus.MODID)
public class PlacementPlus {

	public static final String MODID = "placement_plus";
	public static final String NAME = "Placement+";
	public static final Logger LOGGER = LogManager.getLogger(PlacementPlus.NAME);

	public static MinecraftClient MC;

	public static Boolean disableNormalItemUse = false;
	public static boolean isPlacementPlusEnabled = true;

	public PlacementPlus() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
	}

	private void onClientSetup(final FMLClientSetupEvent evt)
	{
		MC = MinecraftClient.getInstance();
	}



}