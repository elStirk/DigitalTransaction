package net.rpgmyth.digitaltransactions;

import net.rpgmyth.digitaltransactions.events.TransactionTax;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DigitalTransactions extends JavaPlugin {
    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new TransactionTax(), this);
    }


}
