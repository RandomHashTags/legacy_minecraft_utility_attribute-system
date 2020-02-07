package me.randomhashtags.attributesystem.attribute.condition;

import me.randomhashtags.attributesystem.attribute.AbstractEventCondition;
import me.randomhashtags.attributesystem.attribute.Listable;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class IsInList extends AbstractEventCondition implements Listable {
    @Override
    public boolean check(Entity entity, String value) {
        final UUID u = entity.getUniqueId();
        final String[] values = value.split(":");
        final boolean bool = values.length == 1, contains = LIST.containsKey(u) && LIST.get(u).contains(values[0]);
        return contains == (bool || Boolean.parseBoolean(values[1]));
    }
}
