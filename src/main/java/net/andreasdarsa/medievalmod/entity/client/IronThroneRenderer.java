package net.andreasdarsa.medievalmod.entity.client;

import net.andreasdarsa.medievalmod.entity.custom.IronThroneEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class IronThroneRenderer extends EntityRenderer<IronThroneEntity> {
    public IronThroneRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(IronThroneEntity ironThroneEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(IronThroneEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
