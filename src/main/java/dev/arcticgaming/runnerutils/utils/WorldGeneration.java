package dev.arcticgaming.runnerutils.utils;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class WorldGeneration {

    public World createWorlds(String name,Long seed){

        WorldCreator wc = new WorldCreator(name);
        wc.environment(World.Environment.NORMAL);
        wc.type(WorldType.NORMAL);
        wc.seed(seed);
        World world = wc.createWorld();

        WorldCreator nc = new WorldCreator("world_nether");
        nc.environment(World.Environment.NETHER);
        nc.type(WorldType.NORMAL);
        nc.seed(seed);
        nc.createWorld();

        WorldCreator ec = new WorldCreator("world_the_end");
        ec.environment(World.Environment.THE_END);
        ec.type(WorldType.NORMAL);
        ec.seed(seed);
        ec.createWorld();

        return world;
    }
}
