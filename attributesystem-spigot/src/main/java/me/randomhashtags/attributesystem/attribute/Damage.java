package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.HashMap;

public class Damage extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            final LivingEntity l = e instanceof LivingEntity ? (LivingEntity) e : null;
            if(l != null) {
                final String value = recipientValues.get(e);
                if(value != null) {
                    l.damage(evaluate(value));
                }
            }
        }
    }
}
