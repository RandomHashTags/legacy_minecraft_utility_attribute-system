package me.randomhashtags.attributesystem.attribute.condition;

import me.randomhashtags.attributesystem.attribute.AbstractEventCondition;
import me.randomhashtags.attributesystem.attribute.Combo;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class HasCombo extends AbstractEventCondition implements Combo {
    @Override
    public boolean check(Entity entity, String value) {
        final String[] values = value.split(":");
        final String key = values[0];
        final boolean status = values.length == 1 || Boolean.parseBoolean(values[1]);
        final UUID uuid = entity.getUniqueId();
        return COMBOS.containsKey(uuid) && COMBOS.get(uuid).containsKey(key) == status;
    }
}
