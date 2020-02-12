package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

public class ComboDeplete extends AbstractEventAttribute implements Combo {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            final UUID uuid = entity.getUniqueId();
            if(COMBOS.containsKey(uuid)) {
                final HashMap<String, Double> combo = COMBOS.get(uuid);
                final String[] values = recipientValues.get(entity).split(":");
                final String identifier = values[0];
                if(combo.containsKey(identifier)) {
                    combo.put(identifier, combo.get(identifier)-evaluate(values[1]));
                }
            }
        }
    }
}
