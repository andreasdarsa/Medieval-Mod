package net.andreasdarsa.medievalmod.entity.client;

import net.andreasdarsa.medievalmod.entity.custom.WoodenThroneEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class WoodenThroneRenderer extends EntityRenderer<WoodenThroneEntity> {
    public WoodenThroneRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(WoodenThroneEntity woodenThroneEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(WoodenThroneEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
