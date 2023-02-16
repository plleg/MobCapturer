package me.plleg.mobcapturer.adapters.mobs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gson.JsonObject;

import org.bukkit.entity.Tadpole;

import me.plleg.mobcapturer.adapters.MobAdapter;

public class TadpoleAdapter implements MobAdapter<Tadpole> {

    @Override
    @ParametersAreNonnullByDefault
    public void apply(Tadpole entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        entity.setAge(json.get("age").getAsInt());
    }

    @Nonnull
    @Override
    public JsonObject saveData(@Nonnull Tadpole entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("age", entity.getAge());

        return json;
    }

    @Nonnull
    @Override
    public Class<Tadpole> getEntityClass() {
        return Tadpole.class;
    }

}
