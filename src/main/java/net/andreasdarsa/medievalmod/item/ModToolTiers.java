package net.andreasdarsa.medievalmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier EXCALIBUR = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2500,
            12.0f,
            4.0f,
            25,
            () -> Ingredient.of(Items.IRON_INGOT)
    );
}
