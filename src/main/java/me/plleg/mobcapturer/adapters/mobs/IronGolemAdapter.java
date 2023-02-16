package me.plleg.mobcapturer.adapters.mobs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gson.JsonObject;

import org.bukkit.entity.IronGolem;

import me.plleg.mobcapturer.adapters.MobAdapter;

public class IronGolemAdapter implements MobAdapter<IronGolem> {

    @Override
    @ParametersAreNonnullByDefault
    public void apply(IronGolem entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        entity.setPlayerCreated(json.get("playerMade").getAsBoolean());
    }

    @Nonnull
    @Override
    public JsonObject saveData(@Nonnull IronGolem entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("playerMade", entity.isPlayerCreated());

        return json;
    }

    @Nonnull
    @Override
    public Class<IronGolem> getEntityClass() {
        return IronGolem.class;
    }

}
