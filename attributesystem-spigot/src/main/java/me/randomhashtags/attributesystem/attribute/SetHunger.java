package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class SetHunger extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity entity : recipientValues.keySet()) {
            final Player player = entity instanceof Player ? (Player) entity : null;
            if(player != null) {
                final int lvl = player.getFoodLevel();
                player.setFoodLevel((int) evaluate(recipientValues.get(entity).replace("hunger", Integer.toString(lvl))));
            }
        }
    }
}
