package com.msg.stfx.mixin;

// import net.minecraft.src.PotionHelper;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.entity.effect.StatusEffectStrings;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.util.CommonI18n;

@Mixin(PotionItem.class)
public class PotionKeys {

	@Inject(
        method = "getDisplayName",
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
            String splashStr = CommonI18n.translate(newKey).trim();

            if (splashStr != newKey) cir.setReturnValue(splashStr);
        }

	}

    @Inject(
        method = "getDisplayName",
        at = @At(value = "RETURN", ordinal = 2),
        cancellable = true
    )
	private void noEffectPotion(
        ItemStack stack,
        CallbackInfoReturnable<String> cir
    ) {

        String newKey = StatusEffectStrings.method_3478(stack.getData()).replace("potion", "brew");
        String potStr = CommonI18n.translate(newKey).trim();

        // if (potStr != newKey) cir.setReturnValue(potStr);

	}
}
