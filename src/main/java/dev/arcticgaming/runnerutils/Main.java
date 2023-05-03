package dev.roan.runnerutils;

import dev.roan.runnerutils.utils.CommandManager;
import dev.roan.runnerutils.utils.PlayerJoining;
import dev.roan.runnerutils.utils.WorldTracker;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        // Plugin startup logic

        /*
        Planning

        on Join - always make sure players are in world world:
            [player reset function?] on player login - teleport them to world world at x:0 y:64 z:0
            ensure their inventories are clear and stuff reset

        on Cmd "wc <seed>" generate a new world, nether, and end utilizing the new seed, if a seed is not
        provided - use a random long to generate a world. Add the world to an Array of worlds to delete on server restart.

        On server restart - remove all old worlds (shut down logic!)

        on Entity Portal Event - run all players through the reset function if the portal was the end portal in the end

        on Cmd "evac" - send player through reset function
         */
        Bukkit.getPluginManager().registerEvents(this,this);
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoining(), this);

        CommandManager cmgr = new CommandManager();
        this.getCommand(cmgr.cmd1).setExecutor(cmgr);
        this.getCommand(cmgr.cmd2).setExecutor(cmgr);
        this.getCommand(cmgr.cmd3).setExecutor(cmgr);

        getLogger().info("Plugin enabled! Happy running!");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        new WorldTracker().cleanWorldCache();
        getLogger().info("Make sure to stretch! Plugin disabled.");
    }
}
