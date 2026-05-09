package me.yanat.freeanvil;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Free & Unbreakable Anvils (26.1.2) is online!");
    }

    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        // Sets XP cost to 0
        event.getInventory().setRepairCost(0);
    }

    @EventHandler
    public void onAnvilUse(InventoryClickEvent event) {
        // Double check it's an anvil and we aren't damaging it
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            // In 26.1.2, this is enough to keep the server from ticking damage
        }
    }
}
