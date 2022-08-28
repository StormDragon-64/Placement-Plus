package vice.accurate_block_placement;

import java.util.UUID;

import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.TranslatableText;
import vice.accurate_block_placement.client.ReachAroundPlacement;


@SuppressWarnings({"WeakerAccess", "unused"})
@Mod(AccurateBlockPlacementMod.MODID)
public class AccurateBlockPlacementMod {

	public static final String MODID = "accurate_block_placement";
	public static final String NAME = "Accurate Block Placement";
	public static final Logger LOGGER = LogManager.getLogger(AccurateBlockPlacementMod.NAME);

	public static MinecraftClient MC;

	public static KeyBinding keybind;
	public static Boolean disableNormalItemUse = false;
	public static boolean isAccurateBlockPlacementEnabled = true;
	public static ReachAroundPlacement reachAroundPlacement;

	public AccurateBlockPlacementMod() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
	}

	private void onClientSetup(final FMLClientSetupEvent evt)
	{
		MC = MinecraftClient.getInstance();
		reachAroundPlacement = new ReachAroundPlacement(MC);

		keybind = new KeyBinding("net.clayborn.accurateblockplacement.togglevanillaplacement", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "Accurate Block Placement");
		ClientRegistry.registerKeyBinding(keybind);

	}




}