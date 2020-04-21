package me.evilterabite.electricityhurts.Events;

import me.evilterabite.electricityhurts.ElectricityHurts;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.PoweredRail;
import org.bukkit.plugin.Plugin;

public class onShock implements Listener {
    @EventHandler
    public void onShock(PlayerMoveEvent e) {
        Plugin hurts = ElectricityHurts.getPlugin(ElectricityHurts.class);
        Player p = e.getPlayer();
        Server s = Bukkit.getServer();
        Location loc = e.getPlayer().getLocation();
        loc.setY(loc.getY());
        Block block = loc.getBlock();
        Boolean stun = hurts.getConfig().getBoolean("electric_stun");
        double dmg = hurts.getConfig().getDouble("damage_amount");
        if(!p.getGameMode().equals(GameMode.CREATIVE)) {
            if (block.isBlockPowered() | (block.getType() == Material.POWERED_RAIL)) {
                if (p.getInventory().getBoots() == null) {
                    e.setCancelled(stun);
                    p.damage(dmg);
                }
            }

        }

    }
}
