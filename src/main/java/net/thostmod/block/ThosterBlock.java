package net.thostmod.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.thostmod.procedures.InputthostProcedure;
import net.thostmod.procedures.DropthostProcedure;
import net.thostmod.block.entity.ThosterBlockEntity;

public class ThosterBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 6);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final IntegerProperty THOSTAMOUNT = IntegerProperty.create("thostamount", 0, 2);

	public ThosterBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(THOSTAMOUNT, 0).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(2.5, 1, 10.5, 13.5, 9, 12.5), box(2.5, 1, 3.5, 13.5, 9, 5.5), box(3.5, 1, 5.5, 12.5, 2, 10.5), box(3.5, 1, 7.5, 12.5, 8.5, 8.5), box(12.5, 1, 5.5, 14.5, 9, 10.5), box(13.5, 1, 10.5, 14.5, 9, 11.5),
						box(13.5, 1, 4.5, 14.5, 9, 5.5), box(1.5, 1, 4.5, 2.5, 9, 5.5), box(1.5, 1, 10.5, 2.5, 9, 11.5), box(1.5, 1, 5.5, 3.5, 9, 10.5), box(3.5, 8.5, 7.5, 12.5, 9, 8.5), box(2.5, 0, 4.5, 13.5, 1, 11.5),
						box(0.5, 1.475, 7, 1.5, 2.475, 9), box(1.25, 1.5, 7.625, 2, 5.5, 8.375));
				case NORTH -> Shapes.or(box(2.5, 1, 3.5, 13.5, 9, 5.5), box(2.5, 1, 10.5, 13.5, 9, 12.5), box(3.5, 1, 5.5, 12.5, 2, 10.5), box(3.5, 1, 7.5, 12.5, 8.5, 8.5), box(1.5, 1, 5.5, 3.5, 9, 10.5), box(1.5, 1, 4.5, 2.5, 9, 5.5),
						box(1.5, 1, 10.5, 2.5, 9, 11.5), box(13.5, 1, 10.5, 14.5, 9, 11.5), box(13.5, 1, 4.5, 14.5, 9, 5.5), box(12.5, 1, 5.5, 14.5, 9, 10.5), box(3.5, 8.5, 7.5, 12.5, 9, 8.5), box(2.5, 0, 4.5, 13.5, 1, 11.5),
						box(14.5, 1.475, 7, 15.5, 2.475, 9), box(14, 1.5, 7.625, 14.75, 5.5, 8.375));
				case EAST -> Shapes.or(box(10.5, 1, 2.5, 12.5, 9, 13.5), box(3.5, 1, 2.5, 5.5, 9, 13.5), box(5.5, 1, 3.5, 10.5, 2, 12.5), box(7.5, 1, 3.5, 8.5, 8.5, 12.5), box(5.5, 1, 1.5, 10.5, 9, 3.5), box(10.5, 1, 1.5, 11.5, 9, 2.5),
						box(4.5, 1, 1.5, 5.5, 9, 2.5), box(4.5, 1, 13.5, 5.5, 9, 14.5), box(10.5, 1, 13.5, 11.5, 9, 14.5), box(5.5, 1, 12.5, 10.5, 9, 14.5), box(7.5, 8.5, 3.5, 8.5, 9, 12.5), box(4.5, 0, 2.5, 11.5, 1, 13.5),
						box(7, 1.475, 14.5, 9, 2.475, 15.5), box(7.625, 1.5, 14, 8.375, 5.5, 14.75));
				case WEST -> Shapes.or(box(3.5, 1, 2.5, 5.5, 9, 13.5), box(10.5, 1, 2.5, 12.5, 9, 13.5), box(5.5, 1, 3.5, 10.5, 2, 12.5), box(7.5, 1, 3.5, 8.5, 8.5, 12.5), box(5.5, 1, 12.5, 10.5, 9, 14.5), box(4.5, 1, 13.5, 5.5, 9, 14.5),
						box(10.5, 1, 13.5, 11.5, 9, 14.5), box(10.5, 1, 1.5, 11.5, 9, 2.5), box(4.5, 1, 1.5, 5.5, 9, 2.5), box(5.5, 1, 1.5, 10.5, 9, 3.5), box(7.5, 8.5, 3.5, 8.5, 9, 12.5), box(4.5, 0, 2.5, 11.5, 1, 13.5),
						box(7, 1.475, 0.5, 9, 2.475, 1.5), box(7.625, 1.5, 1.25, 8.375, 5.5, 2));
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(2.5, 1, 10.5, 13.5, 9, 12.5), box(2.5, 1, 3.5, 13.5, 9, 5.5), box(3.5, 1, 5.5, 12.5, 2, 10.5), box(3.5, 1, 7.5, 12.5, 8.5, 8.5), box(12.5, 1, 5.5, 14.5, 9, 10.5), box(13.5, 1, 10.5, 14.5, 9, 11.5),
						box(13.5, 1, 4.5, 14.5, 9, 5.5), box(1.5, 1, 4.5, 2.5, 9, 5.5), box(1.5, 1, 10.5, 2.5, 9, 11.5), box(1.5, 1, 5.5, 3.5, 9, 10.5), box(3.5, 8.5, 7.5, 12.5, 9, 8.5), box(2.5, 0, 4.5, 13.5, 1, 11.5),
						box(0.5, 1.475, 7, 1.5, 2.475, 9), box(1.25, 1.5, 7.625, 2, 5.5, 8.375));
				case NORTH -> Shapes.or(box(2.5, 1, 3.5, 13.5, 9, 5.5), box(2.5, 1, 10.5, 13.5, 9, 12.5), box(3.5, 1, 5.5, 12.5, 2, 10.5), box(3.5, 1, 7.5, 12.5, 8.5, 8.5), box(1.5, 1, 5.5, 3.5, 9, 10.5), box(1.5, 1, 4.5, 2.5, 9, 5.5),
						box(1.5, 1, 10.5, 2.5, 9, 11.5), box(13.5, 1, 10.5, 14.5, 9, 11.5), box(13.5, 1, 4.5, 14.5, 9, 5.5), box(12.5, 1, 5.5, 14.5, 9, 10.5), box(3.5, 8.5, 7.5, 12.5, 9, 8.5), box(2.5, 0, 4.5, 13.5, 1, 11.5),
						box(14.5, 1.475, 7, 15.5, 2.475, 9), box(14, 1.5, 7.625, 14.75, 5.5, 8.375));
				case EAST -> Shapes.or(box(10.5, 1, 2.5, 12.5, 9, 13.5), box(3.5, 1, 2.5, 5.5, 9, 13.5), box(5.5, 1, 3.5, 10.5, 2, 12.5), box(7.5, 1, 3.5, 8.5, 8.5, 12.5), box(5.5, 1, 1.5, 10.5, 9, 3.5), box(10.5, 1, 1.5, 11.5, 9, 2.5),
						box(4.5, 1, 1.5, 5.5, 9, 2.5), box(4.5, 1, 13.5, 5.5, 9, 14.5), box(10.5, 1, 13.5, 11.5, 9, 14.5), box(5.5, 1, 12.5, 10.5, 9, 14.5), box(7.5, 8.5, 3.5, 8.5, 9, 12.5), box(4.5, 0, 2.5, 11.5, 1, 13.5),
						box(7, 1.475, 14.5, 9, 2.475, 15.5), box(7.625, 1.5, 14, 8.375, 5.5, 14.75));
				case WEST -> Shapes.or(box(3.5, 1, 2.5, 5.5, 9, 13.5), box(10.5, 1, 2.5, 12.5, 9, 13.5), box(5.5, 1, 3.5, 10.5, 2, 12.5), box(7.5, 1, 3.5, 8.5, 8.5, 12.5), box(5.5, 1, 12.5, 10.5, 9, 14.5), box(4.5, 1, 13.5, 5.5, 9, 14.5),
						box(10.5, 1, 13.5, 11.5, 9, 14.5), box(10.5, 1, 1.5, 11.5, 9, 2.5), box(4.5, 1, 1.5, 5.5, 9, 2.5), box(5.5, 1, 1.5, 10.5, 9, 3.5), box(7.5, 8.5, 3.5, 8.5, 9, 12.5), box(4.5, 0, 2.5, 11.5, 1, 13.5),
						box(7, 1.475, 0.5, 9, 2.475, 1.5), box(7.625, 1.5, 1.25, 8.375, 5.5, 2));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(2.5, 1, 10.5, 13.5, 9, 12.5), box(2.5, 1, 3.5, 13.5, 9, 5.5), box(3.5, 1, 5.5, 12.5, 2, 10.5), box(3.5, 1, 7.5, 12.5, 8.5, 8.5), box(12.5, 1, 5.5, 14.5, 9, 10.5), box(13.5, 1, 10.5, 14.5, 9, 11.5),
					box(13.5, 1, 4.5, 14.5, 9, 5.5), box(1.5, 1, 4.5, 2.5, 9, 5.5), box(1.5, 1, 10.5, 2.5, 9, 11.5), box(1.5, 1, 5.5, 3.5, 9, 10.5), box(3.5, 8.5, 7.5, 12.5, 9, 8.5), box(2.5, 0, 4.5, 13.5, 1, 11.5), box(0.5, 5.5, 7, 1.5, 6.5, 9),
					box(1.25, 1.5, 7.625, 2, 5.5, 8.375));
			case NORTH -> Shapes.or(box(2.5, 1, 3.5, 13.5, 9, 5.5), box(2.5, 1, 10.5, 13.5, 9, 12.5), box(3.5, 1, 5.5, 12.5, 2, 10.5), box(3.5, 1, 7.5, 12.5, 8.5, 8.5), box(1.5, 1, 5.5, 3.5, 9, 10.5), box(1.5, 1, 4.5, 2.5, 9, 5.5),
					box(1.5, 1, 10.5, 2.5, 9, 11.5), box(13.5, 1, 10.5, 14.5, 9, 11.5), box(13.5, 1, 4.5, 14.5, 9, 5.5), box(12.5, 1, 5.5, 14.5, 9, 10.5), box(3.5, 8.5, 7.5, 12.5, 9, 8.5), box(2.5, 0, 4.5, 13.5, 1, 11.5),
					box(14.5, 5.5, 7, 15.5, 6.5, 9), box(14, 1.5, 7.625, 14.75, 5.5, 8.375));
			case EAST -> Shapes.or(box(10.5, 1, 2.5, 12.5, 9, 13.5), box(3.5, 1, 2.5, 5.5, 9, 13.5), box(5.5, 1, 3.5, 10.5, 2, 12.5), box(7.5, 1, 3.5, 8.5, 8.5, 12.5), box(5.5, 1, 1.5, 10.5, 9, 3.5), box(10.5, 1, 1.5, 11.5, 9, 2.5),
					box(4.5, 1, 1.5, 5.5, 9, 2.5), box(4.5, 1, 13.5, 5.5, 9, 14.5), box(10.5, 1, 13.5, 11.5, 9, 14.5), box(5.5, 1, 12.5, 10.5, 9, 14.5), box(7.5, 8.5, 3.5, 8.5, 9, 12.5), box(4.5, 0, 2.5, 11.5, 1, 13.5),
					box(7, 5.5, 14.5, 9, 6.5, 15.5), box(7.625, 1.5, 14, 8.375, 5.5, 14.75));
			case WEST -> Shapes.or(box(3.5, 1, 2.5, 5.5, 9, 13.5), box(10.5, 1, 2.5, 12.5, 9, 13.5), box(5.5, 1, 3.5, 10.5, 2, 12.5), box(7.5, 1, 3.5, 8.5, 8.5, 12.5), box(5.5, 1, 12.5, 10.5, 9, 14.5), box(4.5, 1, 13.5, 5.5, 9, 14.5),
					box(10.5, 1, 13.5, 11.5, 9, 14.5), box(10.5, 1, 1.5, 11.5, 9, 2.5), box(4.5, 1, 1.5, 5.5, 9, 2.5), box(5.5, 1, 1.5, 10.5, 9, 3.5), box(7.5, 8.5, 3.5, 8.5, 9, 12.5), box(4.5, 0, 2.5, 11.5, 1, 13.5), box(7, 5.5, 0.5, 9, 6.5, 1.5),
					box(7.625, 1.5, 1.25, 8.375, 5.5, 2));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, THOSTAMOUNT, WATERLOGGED, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(THOSTAMOUNT, 0).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		DropthostProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		return retval;
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		InteractionResult result = InputthostProcedure.execute(world, x, y, z, blockstate, entity);
		return result;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ThosterBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof ThosterBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof ThosterBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
