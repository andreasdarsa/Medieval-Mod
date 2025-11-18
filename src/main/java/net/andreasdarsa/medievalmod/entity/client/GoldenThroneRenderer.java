package net.andreasdarsa.medievalmod.entity.client;

import net.andreasdarsa.medievalmod.entity.custom.GoldenThroneEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GoldenThroneRenderer extends EntityRenderer<GoldenThroneEntity> {
    public GoldenThroneRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenThroneEntity goldenThroneEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(GoldenThroneEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
