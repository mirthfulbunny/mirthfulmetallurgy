package com.mirthfulbunny.mirthfulmetallurgy.block;

import com.mirthfulbunny.mirthfulmetallurgy.screen.HammeringMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class HammerTableBlock extends SmithingTableBlock {
    public static final Component CONTAINER_TITLE = Component.translatable("container.upgrade");
    public HammerTableBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull MenuProvider getMenuProvider(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos) {
        return new SimpleMenuProvider((pContainerId, pPlayerInventory, player) ->
                new HammeringMenu(pContainerId, pPlayerInventory),
                CONTAINER_TITLE);
    }
}
