package stormdragon_64.placement_plus.mixin;

import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import stormdragon_64.placement_plus.IKeyBindingAccessor;

@Mixin(KeyBinding.class)
public abstract class KeyBindingMixin implements IKeyBindingAccessor
{
	@Shadow
	private int timesPressed;

	@Override
	public int placement_plus_GetTimesPressed()
	{
		return timesPressed;		
	}
}
