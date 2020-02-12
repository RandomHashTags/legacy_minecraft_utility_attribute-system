package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

public class ComboAdd extends AbstractEventAttribute implements Combo {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            final UUID uuid = entity.getUniqueId();
            final String[] values = recipientValues.get(entity).split(":");
            final String identifier = values[0];
            final boolean hasCombo = COMBOS.containsKey(uuid), exists = hasCombo && COMBOS.get(uuid).containsKey(identifier);
            if(!hasCombo) {
                COMBOS.put(uuid, new HashMap<>());
            }
            final HashMap<String, Double> combo = COMBOS.get(uuid);
            combo.put(identifier, exists ? combo.get(identifier)+evaluate(values[1]) : 1.00);
        }
    }
}
