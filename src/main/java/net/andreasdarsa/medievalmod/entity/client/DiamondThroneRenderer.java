package net.andreasdarsa.medievalmod.entity.client;

import net.andreasdarsa.medievalmod.entity.custom.DiamondThroneEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DiamondThroneRenderer extends EntityRenderer<DiamondThroneEntity> {
    public DiamondThroneRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(DiamondThroneEntity diamondThroneEntity) {
        return null;
    }
}
