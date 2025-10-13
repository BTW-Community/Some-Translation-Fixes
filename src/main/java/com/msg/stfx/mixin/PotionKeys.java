package com.msg.stfx.mixin;

import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.StatCollector;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ItemPotion.class)
public class PotionKeys {

	@Inject(
        method = "getItemDisplayName",
        at = @At(value = "RETURN", ordinal = 1),
        cancellable = true,
        locals = LocalCapture.CAPTURE_FAILEXCEPTION
    )
	private void splashPotion(
        ItemStack stack,
        CallbackInfoReturnable<String> cir,
        String var2,
        List var3,
        String var4
    ) {

        if (var2!= ""){

            String newKey = var4 + ".grenade";
            String splashStr = StatCollector.translateToLocal(newKey).trim();

            if (splashStr != newKey) cir.setReturnValue(splashStr);
        }

	}

    @Inject(
        method = "getItemDisplayName",
        at = @At(value = "RETURN", ordinal = 2),
        cancellable = true
    )
	private void noEffectPotion(
        ItemStack stack,
        CallbackInfoReturnable<String> cir
    ) {

        String newKey = PotionHelper.func_77905_c(stack.getItemDamage()).replace("potion", "brew");
        String potStr = StatCollector.translateToLocal(newKey).trim();

        if (potStr != newKey) cir.setReturnValue(potStr);

	}
}
