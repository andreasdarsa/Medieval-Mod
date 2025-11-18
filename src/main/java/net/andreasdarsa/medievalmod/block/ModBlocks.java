package net.andreasdarsa.medievalmod.block;

import net.andreasdarsa.medievalmod.MedievalMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;
import net.andreasdarsa.medievalmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MedievalMod.MOD_ID);

    public static final DeferredBlock<Block> WOODEN_THRONE = registerBlock("wooden_throne",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()));

    public static final DeferredBlock<Block> IRON_THRONE = registerBlock("iron_throne",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()));

    public static final DeferredBlock<Block> GOLDEN_THRONE = registerBlock("golden_throne",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()));

    public static final DeferredBlock<Block> DIAMOND_THRONE = registerBlock("diamond_throne",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
