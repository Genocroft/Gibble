package com.genocraft.gibble.datagen;

import com.genocraft.gibble.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    protected void registerModels() {
        withExistingParent(ModItems.GIBBLE_SPAWN_EGG.getId().getPath(), mcLoc("item/gibble_spawn_egg"));
    }
}
