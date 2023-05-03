package dev.arcticgaming.runnerutils.utils;

import dev.arcticgaming.runnerutils.Reset;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoining implements Listener {

    @EventHandler
    public void onPlayerJoining(PlayerJoinEvent event){
        new Reset().ResetPlayer(event.getPlayer());

    }
}
