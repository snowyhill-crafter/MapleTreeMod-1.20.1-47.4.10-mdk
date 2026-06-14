package com.snowyhill.mapletreemod.event;


import com.snowyhill.mapletreemod.block.SapCollectorBlock;
import com.snowyhill.mapletreemod.registry.ModBlocks;
import com.snowyhill.mapletreemod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mapletreemod") // ←MODIDは自分のものに変更
public class SapCollectorRightClickHandler {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // SapCollectorBlockかどうか判定
        if (state.getBlock() == ModBlocks.SAP_COLLECTOR.get()) {
            int fill = state.getValue(SapCollectorBlock.FILL_LEVEL);

                       // 空きビン（1以上でOK）
            if (held.is(Items.GLASS_BOTTLE) && fill > 0) {
                if (!level.isClientSide) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    player.addItem(new ItemStack(ModItems.MAPLE_SAP_BOTTLE.get()));
                    level.setBlock(pos, state.setValue(SapCollectorBlock.FILL_LEVEL, fill - 1), 3);
                    level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                }
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                return;
            }
        }
    }
}
