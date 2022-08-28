package vice.accurate_block_placement.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vice.accurate_block_placement.AccurateBlockPlacementMod;

import java.util.UUID;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class Events
{
    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent event)
    {
        AccurateBlockPlacementMod.reachAroundPlacement.renderIndicator(event.getPoseStack());
    }
}
