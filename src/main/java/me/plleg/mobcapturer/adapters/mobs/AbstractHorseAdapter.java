package me.plleg.mobcapturer.adapters.mobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.google.gson.JsonObject;

import org.bukkit.ChatColor;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.inventory.ItemStack;

import me.plleg.mobcapturer.adapters.InventoryAdapter;
import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;

class AbstractHorseAdapter<T extends AbstractHorse> extends AbstractTameableAdapter<T> implements InventoryAdapter<T> {

    public AbstractHorseAdapter(@Nonnull Class<T> entityClass) {
        super(entityClass);
    }

    @Nonnull
    @Override
    public List<String> getLore(@Nonnull JsonObject json) {
        List<String> lore = super.getLore(json);

        lore.add(ChatColor.GRAY + "Jump Strength: " + ChatColor.WHITE + NumberUtils.roundDecimalNumber(json.get("jumpStrength").getAsDouble()));

        return lore;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void apply(T entity, JsonObject json) {
        super.apply(entity, json);

        entity.setMaxDomestication(json.get("maxDomestication").getAsInt());
        entity.setDomestication(json.get("domestication").getAsInt());
        entity.setJumpStrength(json.get("jumpStrength").getAsDouble());
    }

    @Nonnull
    @Override
    public JsonObject saveData(@Nonnull T entity) {
        JsonObject json = super.saveData(entity);

        json.addProperty("maxDomestication", entity.getMaxDomestication());
        json.addProperty("domestication", entity.getDomestication());
        json.addProperty("jumpStrength", entity.getJumpStrength());

        return json;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void applyInventory(T entity, Map<String, ItemStack> inventory) {
        entity.getInventory().setSaddle(inventory.get("saddle"));
    }

    @Nonnull
    @Override
    public Map<String, ItemStack> saveInventory(@Nonnull T entity) {
        Map<String, ItemStack> inventory = new HashMap<>();

        inventory.put("saddle", entity.getInventory().getSaddle());

        return inventory;
    }

}
