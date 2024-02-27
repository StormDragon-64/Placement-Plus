package stormdragon_64.placement_plus.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import stormdragon_64.placement_plus.IMinecraftClientAccessor;
import stormdragon_64.placement_plus.PlacementPlus;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin implements IMinecraftClientAccessor
{
	@Shadow
	protected abstract void doItemUse();

	@Shadow
	private int itemUseCooldown;

	@Shadow public ClientPlayerEntity player;

	@Override
	public void placement_plus_DoItemUseBypassDisable()
	{
		Boolean oldValue = PlacementPlus.disableNormalItemUse;
		PlacementPlus.disableNormalItemUse = false;
		doItemUse();
		PlacementPlus.disableNormalItemUse = oldValue;
	}
	
	@Inject(method = "doItemUse", at = @At("HEAD"), cancellable = true)
	void OnDoItemUse(CallbackInfo info)
	{
		if(PlacementPlus.disableNormalItemUse) {
			info.cancel();
		}
	}
	
	@Override
	public void placement_plus_SetItemUseCooldown(int cooldown)
	{
		itemUseCooldown = cooldown;
	}
	
	@Override
	public int placement_plus_GetItemUseCooldown()
	{
		return itemUseCooldown;
	}
}
