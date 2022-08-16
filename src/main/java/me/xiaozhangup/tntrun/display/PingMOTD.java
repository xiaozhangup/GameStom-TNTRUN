package me.xiaozhangup.tntrun.display;

import me.xiaozhangup.tntrun.helper.Base64;
import me.xiaozhangup.tntrun.helper.Config;
import me.xiaozhangup.tntrun.helper.Files;
import net.kyori.adventure.text.Component;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.server.ServerListPingEvent;
import net.minestom.server.ping.ResponseData;

import java.io.File;

public class PingMOTD {

    public static String icon;
    public static String description;
    public static Integer maxplayers;

    public static void load(GlobalEventHandler globalEventHandler) {
        icon = "data:image/png;base64," + Base64.decodeBase64(Files.getFile("server-icon.png"));
        description = Config.getConfig("motd").getString("Description").replace("&", "§");
        maxplayers = Config.getConfig("motd").getInt("Maxplayers");
        globalEventHandler.addListener(ServerListPingEvent.class, event -> {
            ResponseData responseData = event.getResponseData();
            responseData.setMaxPlayer(maxplayers);
            responseData.setFavicon(icon);
            responseData.setDescription(Component.text(description));
            event.setResponseData(responseData);
        });
    }

}
