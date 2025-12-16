package net.andreasdarsa.medievalmod.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.andreasdarsa.medievalmod.entity.ModEntities;
import net.andreasdarsa.medievalmod.entity.custom.WoodenThroneEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class WoodenThroneBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<WoodenThroneBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    // 1. Serialize/Deserialize the DyeColor (using its String representation)
                    StringRepresentable.fromEnum(DyeColor::values).fieldOf("color").forGetter(WoodenThroneBlock::getColor),
                    // 2. Serialize/Deserialize the standard Block Properties
                    Properties.CODEC.fieldOf("properties").forGetter(Block::properties)
            ).apply(instance, WoodenThroneBlock::new)
    );
    public static final VoxelShape SHAPE = Block.box(-4.0D,0.0D,-4.0D,20.0D,24.0D,20.0D);
    private final DyeColor COLOR;

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public WoodenThroneBlock(DyeColor color, Properties properties) {
        super(properties);
        this.COLOR = color;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, net.minecraft.core.Direction.NORTH));
    }

    public DyeColor getColor(){
        return this.COLOR;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()){
            Entity entity = null;
            List<WoodenThroneEntity> entities = level.getEntities(ModEntities.RED_WOODEN_THRONE_ENTITY.get(), new AABB(pos), chair -> true);
            if (entities.isEmpty()){
                entity = ModEntities.RED_WOODEN_THRONE_ENTITY.get().spawn((ServerLevel) level, pos, MobSpawnType.TRIGGERED);
            }
            else{
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
