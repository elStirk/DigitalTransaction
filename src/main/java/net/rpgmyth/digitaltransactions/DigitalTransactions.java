package net.rpgmyth.digitaltransactions;

import net.rpgmyth.digitaltransactions.events.TransactionTax;
import net.rpgmyth.digitaltransactions.utils.LoadTax;
import net.rpgmyth.digitaltransactions.utils.TaxYAML;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.TreeMap;

public final class DigitalTransactions extends JavaPlugin {

    public static Plugin plugin;
    public static TreeMap<Double, Integer> taxBrackets = new TreeMap<>();
    @Override
    public void onEnable() {
        plugin = JavaPlugin.getPlugin(DigitalTransactions.class);
        TaxYAML.registerSettings();
        LoadTax.loadTaxBrackets();
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
