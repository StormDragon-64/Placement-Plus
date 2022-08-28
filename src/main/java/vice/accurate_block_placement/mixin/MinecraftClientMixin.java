package vice.accurate_block_placement.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import vice.accurate_block_placement.AccurateBlockPlacementMod;
import vice.accurate_block_placement.IMinecraftClientAccessor;

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

	@Redirect(method = "doItemUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;"))
	private ItemStack onItemUse(ClientPlayerEntity player, Hand hand) {
		ItemStack itemStack = this.player.getStackInHand(hand);

		AccurateBlockPlacementMod.reachAroundPlacement.checkReachAroundAndExecute(hand, itemStack);

		return itemStack;
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
