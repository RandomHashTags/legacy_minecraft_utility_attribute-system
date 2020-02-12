package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.PendingEventAttribute;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import static me.randomhashtags.randompackage.RandomPackageAPI.API;

public class DropItem extends AbstractEventAttribute {
    @Override
    public void execute(PendingEventAttribute pending) {
        final HashMap<Entity, String> recipientValues = pending.getRecipientValues();
        for(Entity e : recipientValues.keySet()) {
            dropItem(e, recipientValues.get(e).replace("entity", e.getName()), true);
        }
    }
    @Override
    public void executeAt(HashMap<Location, String> locations) {
        for(Location l : locations.keySet()) {
            dropItem(l, locations.get(l), false);
        }
    }

    private void dropItem(Object o, String value, boolean isEntity) {
        final Entity e = isEntity ? (Entity) o : null;
        final Location l = isEntity ? e.getLocation() : (Location) o;

        final ItemStack is = API.d(null, value);
        if(is != null && !is.getType().equals(Material.AIR)) {
            l.getWorld().dropItem(l, is);
        }
    }
}
