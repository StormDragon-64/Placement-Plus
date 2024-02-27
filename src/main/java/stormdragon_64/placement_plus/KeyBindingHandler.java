package stormdragon_64.placement_plus;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class KeyBindingHandler {
    public static final String CATEGORY_NAME = "key.category.placement_plus";
    public static final String KEY_TOGGLE_PLACE_PLUS = "key.place_plus.toggle";

    public static KeyBinding TOGGLE_PLACE_PLUS_KEY = new KeyBinding(KEY_TOGGLE_PLACE_PLUS, KeyConflictContext.IN_GAME, InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_7, CATEGORY_NAME);


    public static final List<KeyBinding> ALL = List.of(TOGGLE_PLACE_PLUS_KEY);

    public static void clientTick(MinecraftClient client){

        if (KeyBindingHandler.TOGGLE_PLACE_PLUS_KEY.wasPressed() && client.player != null) {
            if (PlacementPlus.isPlacementPlusEnabled) {
                PlacementPlus.isPlacementPlusEnabled = false;
                client.player.sendMessage(Text.translatable("response.placement_plus.disabled").fillStyle(Style.EMPTY.withColor(16733525)), true);

                PlacementPlus.LOGGER.atWarn().log("response attempted: enabled");
            } else {
                PlacementPlus.isPlacementPlusEnabled = true;
                client.player.sendMessage(Text.translatable("response.placement_plus.enabled").fillStyle(Style.EMPTY.withColor(5635925)), true);
                PlacementPlus.LOGGER.atWarn().log("response attempted: disabled");
            }
        }

    }

}

