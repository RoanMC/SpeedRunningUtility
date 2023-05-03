package dev.arcticgaming.runnerutils.utils;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WorldTracker {

    ArrayList<World> worlds = new ArrayList<>();

    public void addWorld(World world){

        worlds.add(world);
    }
    public void removeWorld(String worldName){

        World removeWorld = Bukkit.getWorld(worldName);
        worlds.remove(removeWorld);
    }

    public ArrayList<World> getWorlds() {
        return worlds;
    }

    public void cleanWorldCache(){

        for (World world : worlds) {

            Bukkit.unloadWorld(world,false);
            try{
                FileUtils.deleteDirectory(new File(String.valueOf(world)));
            } catch (IOException e) {
            }
        }
    }

    public void cleanWorld(String worldName){

        Bukkit.unloadWorld(worldName,false);
        try{
            FileUtils.deleteDirectory(new File(String.valueOf(worldName)));
        } catch (IOException e) {
        }
    }
}
