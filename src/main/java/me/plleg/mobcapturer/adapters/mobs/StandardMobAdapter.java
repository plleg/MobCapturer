package me.plleg.mobcapturer.adapters.mobs;

import javax.annotation.Nonnull;

import org.bukkit.entity.Mob;

import me.plleg.mobcapturer.adapters.MobAdapter;

public class StandardMobAdapter<T extends Mob> implements MobAdapter<T> {

    private final Class<T> entityClass;

    public StandardMobAdapter(@Nonnull Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Nonnull
    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }

}
