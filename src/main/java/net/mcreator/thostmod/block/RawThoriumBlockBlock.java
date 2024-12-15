
package net.mcreator.thostmod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RawThoriumBlockBlock extends Block {
	public RawThoriumBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}