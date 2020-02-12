package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.randompackage.universal.UMaterial;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.HashMap;

public class SetBlock extends AbstractEventAttribute implements TemporaryBlocks {
    @Override
    public void executeAt(HashMap<Location, String> locations) {
        for(Location l : locations.keySet()) {
            final String[] values = locations.get(l).split(":");

            final UMaterial umaterial = UMaterial.match(values[0].toUpperCase());
            if(umaterial != null) {
                final Block b = l.getBlock();
                final BlockState state = b.getState();
                final UMaterial previous = UMaterial.match(b.getType().name(), state.getRawData());
                b.setType(umaterial.getMaterial());
                if(LEGACY) {
                    state.setRawData(umaterial.getData());
                    state.update(true);
                }

                final int c = values.length;
                if(c >= 2) {
                    tempblocks.put(l, previous);
                    SCHEDULER.scheduleSyncDelayedTask(RANDOM_PACKAGE, () -> {
                       b.setType(previous.getMaterial());
                       if(LEGACY) {
                           state.setRawData(previous.getData());
                       }
                       state.update(true);
                       tempblocks.remove(l);
                    });
                }
            }
        }
    }
}
