package net.andreasdarsa.medievalmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.andreasdarsa.medievalmod.entity.ModEntities;
import net.andreasdarsa.medievalmod.entity.custom.IronThroneEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IronThroneBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<IronThroneBlock> CODEC = simpleCodec(IronThroneBlock::new);
    public static final VoxelShape SHAPE = Block.box(-4.0D,0.0D,-4.0D,20.0D,24.0D,20.0D);
    protected IronThroneBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()){
            Entity entity = null;
            List<IronThroneEntity> entities = level.getEntities(ModEntities.IRON_THRONE_ENTITY.get(), new AABB(pos), chair -> true);
            if (entities.isEmpty()) {
                entity = ModEntities.IRON_THRONE_ENTITY.get().spawn((ServerLevel)level, pos, MobSpawnType.TRIGGERED);
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
        return null;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
