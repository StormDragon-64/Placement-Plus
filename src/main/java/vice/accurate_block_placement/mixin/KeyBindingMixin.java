package vice.accurate_block_placement.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.option.KeyBinding;
import vice.accurate_block_placement.IKeyBindingAccessor;

@Mixin(KeyBinding.class)
public abstract class KeyBindingMixin implements IKeyBindingAccessor
{
	@Shadow
	private int timesPressed;
	
	@Override
	public int accurateblockplacement_GetTimesPressed()
	{
		return timesPressed;		
	}
}
