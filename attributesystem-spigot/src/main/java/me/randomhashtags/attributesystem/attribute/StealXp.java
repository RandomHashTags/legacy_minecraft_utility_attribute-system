package me.randomhashtags.attributesystem.attribute;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class StealXp extends AbstractEventAttribute {
    @Override
    public void execute(Entity entity1, Entity entity2, String value) {
        if(entity1 instanceof Player && entity2 instanceof Player && value != null) {
            final Player player = (Player) entity1, victim = (Player) entity2;
            final int victimXp = getTotalExperience(victim), targetXp = Integer.parseInt(value), stolenXp = Math.min(victimXp, targetXp);
            setTotalExperience(victim, victimXp-stolenXp);
            setTotalExperience(player, getTotalExperience(player)+stolenXp);
        }
    }
}
