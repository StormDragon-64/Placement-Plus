package stormdragon.accurate_block_placement;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.MinecraftClient;

@SuppressWarnings({"WeakerAccess", "unused"})
@Mod(AccurateBlockPlacementMod.MODID)
public class AccurateBlockPlacementMod {

	public static final String MODID = "accurate_block_placement";
	public static final String NAME = "Accurate Block Placement Retempered";
	public static final Logger LOGGER = LogManager.getLogger(AccurateBlockPlacementMod.NAME);

	public static MinecraftClient MC;

	//public static KeyBinding keybind;
	public static Boolean disableNormalItemUse = false;
	public static boolean isAccurateBlockPlacementEnabled = true;

	public AccurateBlockPlacementMod() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
	}

	private void onClientSetup(final FMLClientSetupEvent evt)
	{
		MC = MinecraftClient.getInstance();

		//keybind = new KeyBinding("net.clayborn.accurateblockplacement.togglevanillaplacement", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "Accurate Block Placement");
		//ForgeRegistries..registerKeyBinding(keybind);

	}




}