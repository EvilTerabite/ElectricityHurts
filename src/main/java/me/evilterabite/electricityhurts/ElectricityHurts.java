package me.evilterabite.electricityhurts;

import me.evilterabite.electricityhurts.Events.onShock;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElectricityHurts extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new onShock(), this);
        this.saveDefaultConfig();
        System.out.println("---Electricity Hurts Enabled---");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
