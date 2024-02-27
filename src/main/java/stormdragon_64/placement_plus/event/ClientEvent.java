package stormdragon_64.placement_plus.event;

import net.minecraft.client.MinecraftClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import stormdragon_64.placement_plus.KeyBindingHandler;
import stormdragon_64.placement_plus.PlacementPlus;

public class ClientEvent {


    @Mod.EventBusSubscriber(modid = PlacementPlus.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                KeyBindingHandler.clientTick(MinecraftClient.getInstance());
            }
        }

        @Mod.EventBusSubscriber(modid = PlacementPlus.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents {
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event) {
                event.register(KeyBindingHandler.TOGGLE_PLACE_PLUS_KEY);
            }
        }
    }
}
