package me.plleg.mobcapturer.adapters.mobs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gson.JsonObject;

import org.bukkit.entity.GlowSquid;

import me.plleg.mobcapturer.adapters.MobAdapter;

public class GlowSquidAdapter implements MobAdapter<GlowSquid> {

    @Override
    @ParametersAreNonnullByDefault
    public void apply(GlowSquid entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        entity.setDarkTicksRemaining(json.get("darkTicksRemaining").getAsInt());
    }

    @Nonnull
    @Override
    public JsonObject saveData(@Nonnull GlowSquid entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("darkTicksRemaining", entity.getDarkTicksRemaining());

        return json;
    }

    @Nonnull
    @Override
    public Class<GlowSquid> getEntityClass() {
        return GlowSquid.class;
    }

}
