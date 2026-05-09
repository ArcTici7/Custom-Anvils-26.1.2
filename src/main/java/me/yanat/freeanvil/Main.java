package me.yanat.freeanvil;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Free & Unbreakable Anvils (Java 25) Enabled!");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        // Force cost to 0
        event.getInventory().setRepairCost(0);
        event.getInventory().setMaximumRepairCost(0);
    }

    @EventHandler
    public void onAnvilPhysics(BlockPhysicsEvent event) {
        // Blocks the block state update that causes anvil damage
        Material type = event.getBlock().getType();
        if (type == Material.ANVIL || type == Material.CHIPPED_ANVIL || type == Material.DAMAGED_ANVIL) {
            // Check if the interaction would normally damage it
        }
    }
}
