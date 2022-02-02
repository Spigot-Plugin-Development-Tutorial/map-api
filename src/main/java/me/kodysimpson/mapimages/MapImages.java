package me.kodysimpson.mapimages;

import me.kodysimpson.mapimages.commands.MapTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class MapImages extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("testmap").setExecutor(new MapTest());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
