package com.elytrastand.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public abstract class PlayerEntityModelMixin {

    @Inject(method = "setAngles", at = @At("TAIL"))
    private void elytrastand$standingGlidePose(
            AbstractClientPlayerEntity player,
            float limbAngle,
            float limbDistance,
            float animationProgress,
            float headYaw,
            float headPitch,
            CallbackInfo ci
    ) {
        if (!player.isFallFlying()) {
            return;
        }

        PlayerEntityModel<?> model =
                (PlayerEntityModel<?>)(Object)this;

        model.body.pitch = 0.0F;
        model.body.yaw = 0.0F;
        model.body.roll = 0.0F;

        model.head.pitch = headPitch * 0.017453292F;
        model.head.yaw = headYaw * 0.017453292F;

        model.rightArm.pitch = -0.15F;
        model.leftArm.pitch = -0.15F;

        model.rightArm.roll = -0.12F;
        model.leftArm.roll = 0.12F;

        model.rightLeg.pitch = 0.0F;
        model.leftLeg.pitch = 0.0F;

        model.rightLeg.yaw = 0.0F;
        model.leftLeg.yaw = 0.0F;
    }
}
