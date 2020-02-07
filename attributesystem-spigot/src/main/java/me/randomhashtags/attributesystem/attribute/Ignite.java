package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public class Ignite extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            ignite(e, recipientValues.get(e));
        }
    }
    private void ignite(Entity entity, String value) {
        entity.setFireTicks((int) evaluate(value));
    }
}
