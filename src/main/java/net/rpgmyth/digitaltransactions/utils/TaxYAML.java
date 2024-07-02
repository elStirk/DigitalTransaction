package net.rpgmyth.digitaltransactions.utils;

import net.rpgmyth.digitaltransactions.DigitalTransactions;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class TaxYAML {
    private static FileConfiguration settings = null;
    private static File settingsFile = null;
    public static FileConfiguration getSettings(){

        if(settings == null){
            reloadSettings();
        }
        return settings;
    }

    public static void reloadSettings(){
        if(settings == null){
            settingsFile = new File(DigitalTransactions.plugin.getDataFolder(),"taxes.yml");
        }
        settings = YamlConfiguration.loadConfiguration(settingsFile);
        Reader defConfigStream;
        InputStream inputStream = DigitalTransactions.plugin.getResource("taxes.yml");
        if (inputStream != null) {
            defConfigStream = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            settings.setDefaults(defConfig);
        }
    }

    public static void saveSettings(){
        try{
            settings.save(settingsFile);
        }catch(IOException e){
            DigitalTransactions.plugin.getLogger().severe("Could not save config to " + settingsFile);
        }
    }

    public static void registerSettings(){
        settingsFile = new File(DigitalTransactions.plugin.getDataFolder(),"taxes.yml");
        if(!settingsFile.exists()){
            getSettings().options().copyDefaults(true);
            saveSettings();
        }
    }
}
