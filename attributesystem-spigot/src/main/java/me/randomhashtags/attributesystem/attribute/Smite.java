package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public class Smite extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, HashMap<String, String> valueReplacements) {
        final HashMap<String, Entity> entities = pending.getEntities();
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            final String entityValue = recipientValues.get(entity);
            if(entityValue != null) {
                final String[] values = entityValue.split(":");
                final boolean at = values.length >= 2;
                final String value = replaceValue(entities, at ? values[1] : values[0], valueReplacements);
                final World w = entity.getWorld();
                final Location l = at ? toLocation(replaceValue(entities, values[0], valueReplacements)) : entity.getLocation();
                if(l != null) {
                    for(int i = 1; i <= (int) evaluate(value); i++) {
                        w.strikeLightning(l);
                    }
                }
            }
        }
    }
}
