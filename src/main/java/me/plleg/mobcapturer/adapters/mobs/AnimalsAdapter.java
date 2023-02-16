package me.plleg.mobcapturer.adapters.mobs;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gson.JsonObject;

import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;

import me.plleg.mobcapturer.adapters.MobAdapter;

public class AnimalsAdapter<T extends Animals> implements MobAdapter<T> {

    private final Class<T> entityClass;

    public AnimalsAdapter(@Nonnull Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Nonnull
    @Override
    public List<String> getLore(@Nonnull JsonObject json) {
        List<String> lore = MobAdapter.super.getLore(json);

        lore.add(ChatColor.GRAY + "Baby: " + ChatColor.WHITE + json.get("baby").getAsBoolean());

        return lore;
    }

    @Nonnull
    @Override
    public JsonObject saveData(@Nonnull T entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("baby", !entity.isAdult());
        json.addProperty("_age", entity.getAge());
        json.addProperty("_ageLock", entity.getAgeLock());
        json.addProperty("_breedable", entity.canBreed());
        json.addProperty("_loveModeTicks", entity.getLoveModeTicks());

        return json;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void apply(T entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        entity.setAge(json.get("_age").getAsInt());
        entity.setLoveModeTicks(json.get("_loveModeTicks").getAsInt());
        entity.setAgeLock(json.get("_ageLock").getAsBoolean());
        entity.setBreed(json.get("_breedable").getAsBoolean());
    }

    @Nonnull
    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }

}
