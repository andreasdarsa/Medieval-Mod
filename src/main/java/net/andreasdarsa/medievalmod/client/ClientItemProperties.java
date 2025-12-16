package net.andreasdarsa.medievalmod.client;

import net.andreasdarsa.medievalmod.MedievalMod;
import net.andreasdarsa.medievalmod.item.ModItems;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ClientItemProperties {
    // --- PROPERTY FUNCTION FOR CUSTOM TEXTURE OVERRIDE ---
    // This function calculates the "damage_state" property used by the JSON model.
    private static final ClampedItemPropertyFunction DAMAGE_STATE_PROPERTY = (stack, level, entity, seed) -> {
        // Durability is 1 - (damage / max_damage)
        float durability = 1.0f - stack.getDamageValue() / (float)stack.getMaxDamage();

        // If durability is 50% or less, return 1.0 (to trigger the damaged texture override in the JSON model)
        if (durability <= 0.5f) {
            return 1.0f;
        }
        return 0.0f; // Otherwise, return 0.0 (uses the base texture)
    };

    public static void register() {
        // Register the damage state property for the Excalibur item.
        // This links the Java logic to the ResourceLocation used in the excalibur.json model's 'predicate' block.
        registerProperty(
                ModItems.EXCALIBUR.get(), // The item instance
                ResourceLocation.fromNamespaceAndPath(MedievalMod.MOD_ID, "damage_state"), // The property name in the JSON
                DAMAGE_STATE_PROPERTY // The function that calculates the value
        );
    }

    private static void registerProperty(Item item, ResourceLocation location, ClampedItemPropertyFunction propertyFunction) {
        ItemProperties.register(item, location, propertyFunction);
    }
}
