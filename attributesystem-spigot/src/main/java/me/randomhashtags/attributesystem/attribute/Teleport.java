package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashMap;

public class Teleport extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, HashMap<String, String> valueReplacements) {
        final HashMap<String, Entity> entities = pending.getEntities();
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            final String value = replaceValue(entities, recipientValues.get(entity), valueReplacements);
            final Location l = toLocation(value);
            if(l != null) {
                entity.teleport(l, PlayerTeleportEvent.TeleportCause.PLUGIN);
            }
        }
    }
}
