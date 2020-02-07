package me.randomhashtags.attributesystem.attribute;

import me.randomhashtags.attributesystem.universal.UMaterial;
import org.bukkit.Location;

import java.util.HashMap;

public interface TemporaryBlocks {
    HashMap<Location, UMaterial> tempblocks = new HashMap<>();
}
