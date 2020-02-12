package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class LaunchProj extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending, HashMap<String, String> valueReplacements) {
        final Event event = pending.getEvent();
        final HashMap<String, Entity> entities = pending.getEntities();
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        Vector vector = null;
        if(event instanceof ProjectileLaunchEvent) {
            vector = ((ProjectileLaunchEvent) event).getEntity().getVelocity();
        }
        for(Entity entity : recipientValues.keySet()) {
            String value = recipientValues.get(entity);
            if(value != null && entity instanceof LivingEntity) {
                final LivingEntity l = (LivingEntity) entity;
                value = replaceValue(entities, value, valueReplacements);
                final EntityType type = EntityType.valueOf(value.toUpperCase());
                final Projectile proj = (Projectile) l.getWorld().spawnEntity(l.getEyeLocation(), type);
                if(vector != null) proj.setVelocity(vector);
                proj.setShooter(l);
            }
        }
    }
}
