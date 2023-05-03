package dev.arcticgaming.runnerutils.utils;

import dev.arcticgaming.runnerutils.Reset;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CommandManager implements CommandExecutor {

    Tools tool = new Tools();
    WorldTracker tracker = new WorldTracker();
    Reset reset = new Reset();

    public String cmd1 = "evac";
    public String cmd2 = "wc";
    public String cmd3 = "clean";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase(cmd1)) {
            if (sender instanceof Player) {

                reset.ResetPlayer((Player) sender);
                tool.log("Players returned to spawn");

                return true;


            } else {

                tool.log("Console cannot be returned to spawn, dummy");
                return true;

            }
        } else if (command.getName().equalsIgnoreCase(cmd2)) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length > 2 || args.length == 0) {
                    player.sendActionBar("too many arguments! please provide a name and seed only");
                    return true;
                } else {

                    if (args.length == 2) {
                        if (tool.isLong(args[1])) {
                            WorldTracker tracker = new WorldTracker();
                            tracker.cleanWorld("world_nether");
                            tracker.cleanWorld("world_the_end");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            World newWorld = new WorldGeneration().createWorlds(args[0], Long.parseLong(args[1]));
                            tracker.addWorld(newWorld);
                            double lx = 0.0;
                            double ly = 64.0;

                            Location loc = new Location(newWorld, lx, ly, lx);
                            for (Player players : Bukkit.getOnlinePlayers()) {

                                players.teleport(loc);
                                return true;
                            }

                        }
                    } else if (args.length == 1) {

                        Random random = new Random();
                        Long tempSeed = random.nextLong();
                        World newWorld = new WorldGeneration().createWorlds(args[0], tempSeed);

                        double lx = 0.0;
                        double ly = 64.0;

                        Location loc = new Location(newWorld, lx, ly, lx);
                        for (Player players : Bukkit.getOnlinePlayers()) {

                            players.teleport(loc);
                            return true;
                        }
                    }
                }
            }
        } else if (command.getName().equalsIgnoreCase(cmd3)) {
            String chop = args[0];

            tracker.removeWorld(chop);
            tracker.cleanWorld(chop);
        }
        return false;
    }
}
