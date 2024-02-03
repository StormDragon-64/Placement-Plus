package stormdragon.accurate_block_placement.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import stormdragon.accurate_block_placement.AccurateBlockPlacementMod;
import stormdragon.accurate_block_placement.IMinecraftClientAccessor;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin implements IMinecraftClientAccessor
{
	@Shadow
	protected abstract void doItemUse();

	@Shadow
	private int itemUseCooldown;

	@Shadow public ClientPlayerEntity player;

	@Override
	public void accurateblockplacement_DoItemUseBypassDisable()
	{
		Boolean oldValue = AccurateBlockPlacementMod.disableNormalItemUse;
		AccurateBlockPlacementMod.disableNormalItemUse = false;
		doItemUse();
		AccurateBlockPlacementMod.disableNormalItemUse = oldValue;
	}
	
	@Inject(method = "doItemUse", at = @At("HEAD"), cancellable = true)
	void OnDoItemUse(CallbackInfo info)
	{
		if(AccurateBlockPlacementMod.disableNormalItemUse) {
			info.cancel();
		}
	}
	
	@Override
	public void accurateblockplacement_SetItemUseCooldown(int cooldown)
	{
		itemUseCooldown = cooldown;
	}
	
	@Override
	public int accurateblockplacement_GetItemUseCooldown()
	{
		return itemUseCooldown;
	}
}
