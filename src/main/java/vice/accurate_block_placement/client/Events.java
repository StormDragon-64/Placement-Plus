package vice.accurate_block_placement.client;

import net.minecraft.network.MessageType;
import net.minecraft.text.TranslatableText;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vice.accurate_block_placement.AccurateBlockPlacementMod;

import java.util.UUID;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class Events
{
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.ClientTickEvent event)
    {
        while(AccurateBlockPlacementMod.keybind.wasPressed()) {
            AccurateBlockPlacementMod.isAccurateBlockPlacementEnabled = !AccurateBlockPlacementMod.isAccurateBlockPlacementEnabled;

            TranslatableText message = null;

            if(AccurateBlockPlacementMod.isAccurateBlockPlacementEnabled) {
                message = new TranslatableText("net.clayborn.accurateblockplacement.modplacementmodemessage");
            }
            else {
                message = new TranslatableText("net.clayborn.accurateblockplacement.vanillaplacementmodemessage");
            }

            AccurateBlockPlacementMod.MC.inGameHud.addChatMessage(MessageType.SYSTEM, message, UUID.fromString("00000000-0000-0000-0000-000000000000"));
        }
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGameOverlayEvent event)
    {
        AccurateBlockPlacementMod.reachAroundPlacement.renderIndicator(event.getMatrixStack());
    }
}
