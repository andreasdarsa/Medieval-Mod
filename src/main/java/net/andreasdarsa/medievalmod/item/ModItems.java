package net.andreasdarsa.medievalmod.item;

import net.andreasdarsa.medievalmod.MedievalMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MedievalMod.MOD_ID);

    public static final DeferredItem<SwordItem> EXCALIBUR = ITEMS.register("excalibur",
            () -> new SwordItem(ModToolTiers.EXCALIBUR, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.EXCALIBUR, 5, -2.4f))));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
