package com.mirthfulbunny.mirthfulmetallurgy.plugin;

import com.mirthfulbunny.mirthfulmetallurgy.MirthfulMetallurgy;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MirthfulMetallurgy.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // This is where you would manually add recipes if they aren't standard
    }
}
