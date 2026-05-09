package me.yanat.freeanvil;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Anvil Rebate System (Java 25) Active");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        // Set cost to 1 to keep the client UI (Red Cross) happy
        event.getInventory().setRepairCost(1);
        event.getInventory().setMaximumRepairCost(1000);
    }

    @EventHandler
    public void onAnvilTake(InventoryClickEvent event) {
        // Check if the player is clicking in an anvil
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            // Slot 2 is the result slot in an anvil
            if (event.getRawSlot() == 2 && event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
                Player player = (Player) event.getWhoClicked();
                
                // Give the 1 level back immediately
                // We use a small delay (1 tick) to ensure the vanilla cost is taken first
                getServer().getScheduler().runTaskLater(this, () -> {
                    player.setLevel(player.getLevel() + 1);
                }, 1L);
            }
        }
    }
}
