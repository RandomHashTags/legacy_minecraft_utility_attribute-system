package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class AddToList extends AbstractEventAttribute implements Listable {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            if(entity != null) {
                final UUID u = entity.getUniqueId();
                if(!LIST.containsKey(u)) {
                    LIST.put(u, new ArrayList<>());
                }
                LIST.get(u).add(recipientValues.get(entity));
            }
        }
    }
}
