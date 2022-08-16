package me.xiaozhangup.tntrun;

import me.xiaozhangup.tntrun.config.Loadin;
import me.xiaozhangup.tntrun.display.PingMOTD;
import me.xiaozhangup.tntrun.helper.Config;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class TNTRun {

    public static MinecraftServer minecraftServer = MinecraftServer.init();
    public static InstanceManager instanceManager = MinecraftServer.getInstanceManager();
    public static InstanceContainer instanceContainer = instanceManager.createInstanceContainer();
    static GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();

    public static void main(String[] args) {

        PingMOTD.load(globalEventHandler);
        setSpawn();

        Loadin.load();

        minecraftServer.start("0.0.0.0", 25565);

    }

    public static void setSpawn() {
        globalEventHandler.addListener(PlayerLoginEvent.class, event -> {
                    final Player player = event.getPlayer();
                    event.setSpawningInstance(instanceContainer);
                    player.setRespawnPoint(new Pos(0, 16, 0));
                    player.setItemInMainHand(ItemStack.of(Material.WOODEN_SWORD));
                    player.setGameMode(GameMode.CREATIVE);
        });
    }

}
