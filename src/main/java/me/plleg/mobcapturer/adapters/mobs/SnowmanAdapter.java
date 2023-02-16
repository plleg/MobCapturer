package me.plleg.mobcapturer.adapters.mobs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gson.JsonObject;

import org.bukkit.entity.Snowman;

import me.plleg.mobcapturer.adapters.MobAdapter;

public class SnowmanAdapter implements MobAdapter<Snowman> {

    @Override
    @ParametersAreNonnullByDefault
    public void apply(Snowman entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        entity.setDerp(json.get("derp").getAsBoolean());
    }

    @Nonnull
    @Override
    public JsonObject saveData(@Nonnull Snowman entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("derp", entity.isDerp());

        return json;
    }

    @Nonnull
    @Override
    public Class<Snowman> getEntityClass() {
        return Snowman.class;
    }

}
