package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

public class RemoveFromList extends AbstractEventAttribute implements Listable {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            if(entity != null) {
                final UUID uuid = entity.getUniqueId();
                if(LIST.containsKey(uuid)) {
                    LIST.get(uuid).remove(recipientValues.get(entity));
                }
            }
        }
    }
}
