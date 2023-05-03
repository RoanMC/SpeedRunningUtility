package dev.arcticgaming.runnerutils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Reset {

    public boolean ResetPlayer(Player player) {

        Double locx = 0.0;
        Double locy = 64.1;
        Double locz = 0.0;
        World world = Bukkit.getWorld("world");
        Location spawn = new Location(world,locx,locy,locz);
        player.teleport(spawn);
        player.getInventory().clear();



        return true;
    }
}
