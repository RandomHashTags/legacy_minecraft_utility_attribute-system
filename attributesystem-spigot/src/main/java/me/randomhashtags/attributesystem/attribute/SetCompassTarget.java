package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class SetCompassTarget extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            if(entity instanceof Player) {
                final String[] values = recipientValues.get(entity).split(":");
                ((Player) entity).setCompassTarget(new Location(entity.getWorld(), evaluate(values[0]), evaluate(values[1]), evaluate(values[2])));
            }
        }
    }
}
