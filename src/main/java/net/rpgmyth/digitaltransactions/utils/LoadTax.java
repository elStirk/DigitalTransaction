package net.rpgmyth.digitaltransactions.utils;

import net.rpgmyth.digitaltransactions.DigitalTransactions;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class LoadTax {
    public static void loadTaxBrackets(){
        FileConfiguration config = TaxYAML.getSettings();
        ConfigurationSection taxSection = config.getConfigurationSection("Tax");
        if (taxSection == null) return;
        taxSection.getKeys(false).forEach(key -> {
            int tax = config.getInt("Tax."+key);
            DigitalTransactions.taxBrackets.put(Double.valueOf(key), tax);
        });
        int maxTax = config.getInt("Max");
        DigitalTransactions.taxBrackets.put(Double.MAX_VALUE, maxTax);
    }
}
