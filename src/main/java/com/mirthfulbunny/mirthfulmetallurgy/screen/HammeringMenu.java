package com.mirthfulbunny.mirthfulmetallurgy.screen;

import com.mirthfulbunny.mirthfulmetallurgy.block.ModBlocks;
import com.mirthfulbunny.mirthfulmetallurgy.recipe.HammeringRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class HammeringMenu extends ItemCombinerMenu {
    public static final int INPUT_SLOT = 0;
    public static final int PRIMARY_OUTPUT_SLOT = 1;
    public static final int SECONDARY_OUTPUT_SLOT = 38;
    private final Container customResultSlots = new SimpleContainer(1);

    private final Level level;
    @Nullable
    private HammeringRecipe selectedRecipe;
    private final List<HammeringRecipe> recipes;

    public HammeringMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf data) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public HammeringMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public HammeringMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(ModMenuTypes.HAMMERING_MENU.get(), pContainerId, pPlayerInventory, pAccess);
        this.level = pPlayerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(HammeringRecipe.Type.INSTANCE);

        this.addSlot(new Slot(this.customResultSlots, 0, 134, 47) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) { return false; }
        });
    }



    @Override
    protected boolean mayPickup(@NotNull Player pPlayer, boolean pHasStack) {
        return this.selectedRecipe != null && this.selectedRecipe.matches(this.inputSlots, this.level);
    }

    @Override
    protected void onTake(@NotNull Player pPlayer, @NotNull ItemStack pStack) {
        if (this.selectedRecipe != null) {
            this.resultSlots.awardUsedRecipes(pPlayer, List.of(this.inputSlots.getItem(INPUT_SLOT)));

            this.inputSlots.getItem(INPUT_SLOT).shrink(this.selectedRecipe.getIngredientCount());

            if(this.customResultSlots.getItem(0).is(this.selectedRecipe.getSecondaryOutput().getItem())) {
                this.customResultSlots.getItem(0).grow(1);
            } else {
                this.customResultSlots.setItem(0, this.selectedRecipe.getSecondaryOutput().copy());
            }

            this.customResultSlots.setChanged();

            // Play effects
            this.access.execute((level, pos) -> {
                level.levelEvent(1044, pos, 0);
                level.playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
            });
            createResult();
        }
        this.broadcastChanges();
    }

    @Override
    protected boolean isValidBlock(@NotNull BlockState pState) {
        return pState.is(ModBlocks.HAMMER_TABLE.get());
    }

    @Override
    public void createResult() {
        Optional<HammeringRecipe> r = this.level.getRecipeManager().getRecipeFor(HammeringRecipe.Type.INSTANCE, this.inputSlots, this.level);
        if(r.isPresent()) {
            this.resultSlots.setItem(0, r.get().getPrimaryOutput().copy());
            //this.customResultSlots.setItem(0, r.get().getSecondaryOutput().copy());
            this.selectedRecipe = r.get();
        } else {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
            //this.customResultSlots.setItem(0, ItemStack.EMPTY);
            this.selectedRecipe = null;
        }

        // Force the server to sync these changes to the client screen
        this.broadcastChanges();
    }

    @Override
    public void removed(@NotNull Player player) {
        // 1. Manually return items to the player, bypassing the block-check
        // that usually causes them to vanish if the access is NULL or invalid.
        this.clearContainer(player, this.inputSlots);
        this.clearContainer(player, this.customResultSlots);

        // 2. Call super last. It will try to clear inputSlots again via
        // the access lambda, but since they are already empty, it's safe.
        super.removed(player);
    }

    @Override
    protected @NotNull ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(INPUT_SLOT, 47, 47, itemStack -> this.recipes.stream().anyMatch(hammeringRecipe -> hammeringRecipe.getInputItem().test(itemStack)))
                .withResultSlot(PRIMARY_OUTPUT_SLOT, 112, 47)
                .build();
    }

    @Override
    protected boolean canMoveIntoInputSlots(@NotNull ItemStack pStack) {
        return this.recipes.stream().anyMatch(hammeringRecipe -> hammeringRecipe.getInputItem().test(pStack));
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            // If the index is an output slot (Primary or Secondary)
            if (index == PRIMARY_OUTPUT_SLOT || index == SECONDARY_OUTPUT_SLOT) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            }
            // If the index is the input slot
            else if (index == INPUT_SLOT) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            }
            // If the index is in the player inventory
            else if (index >= 2 && index < 38) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }
}
