package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.HashMap;

public class SetNoDamageTicks extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            if(entity instanceof LivingEntity) {
                final LivingEntity l = (LivingEntity) entity;
                l.setNoDamageTicks((int) evaluate(recipientValues.get(entity).replace("ticks", Integer.toString(l.getNoDamageTicks()))));
            }
        }
    }
}
