package me.randomhashtags.attributesystem.attribute.faction;

import com.massivecraft.factions.Faction;
import me.randomhashtags.attributesystem.attribute.AbstractEventAttribute;
import me.randomhashtags.attributesystem.EventEntities;
import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.HashMap;

public class AddFactionPower extends AbstractEventAttribute implements EventEntities {
    @Override
    public void execute(PendingEventAttribute pending, HashMap<String, String> valueReplacements) {
        final Event event = pending.getEvent();
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            if(e instanceof Player) {
                final Faction f = factions.getFaction(e.getUniqueId());
                if(f != null) {
                    f.setPowerBoost(f.getPowerBoost()+evaluate(replaceValue(getEntities(event), recipientValues.get(e), valueReplacements)));
                }
            }
        }
    }
}
