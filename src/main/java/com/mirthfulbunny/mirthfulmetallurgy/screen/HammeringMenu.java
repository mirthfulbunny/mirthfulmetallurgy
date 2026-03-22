package com.mirthfulbunny.mirthfulmetallurgy.screen;

import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HammeringMenu extends ItemCombinerMenu {
    public static final int INPUT_SLOT = 0;
    public static final int PRIMARY_OUTPUT_SLOT = 1;
    public static final int SECONDARY_OUTPUT_SLOT = 2;

    private final Container customResultSlots = new SimpleContainer(1);

    private final Level level;
    @Nullable
    private SmithingRecipe selectedRecipe;
    private final List<SmithingRecipe> recipes;

    public HammeringMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf data) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public HammeringMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public HammeringMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(ModMenuTypes.HAMMERING_MENU.get(), pContainerId, pPlayerInventory, pAccess);
        this.level = pPlayerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(RecipeType.SMITHING);

        this.addSlot(new Slot(this.customResultSlots, 0, 134, 47) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) { return false; }
        });
    }



    @Override
    protected boolean mayPickup(@NotNull Player pPlayer, boolean pHasStack) {
        return false;
    }

    @Override
    protected void onTake(@NotNull Player pPlayer, @NotNull ItemStack pStack) {

    }

    @Override
    protected boolean isValidBlock(@NotNull BlockState pState) {
        return pState.is(ModBlocks.HAMMER_TABLE.get());
    }

    @Override
    public void createResult() {

    }

    @Override
    protected @NotNull ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(INPUT_SLOT, 47, 47, itemStack -> true)
                .withResultSlot(PRIMARY_OUTPUT_SLOT, 112, 47)
                .build();
    }
}
