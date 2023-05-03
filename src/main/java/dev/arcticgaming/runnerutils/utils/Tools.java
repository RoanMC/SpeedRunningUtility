package dev.roan.runnerutils.utils;

import dev.roan.runnerutils.Main;

public class Tools {

    Main plugin = Main.getPlugin(Main.class);

    public void log(String log){
        plugin.getLogger().info(log);
    }

    public boolean isLong(String checkme){
        try {
            Long.parseLong(checkme);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
