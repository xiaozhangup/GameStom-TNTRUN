package me.xiaozhangup.tntrun.config;

import me.xiaozhangup.tntrun.helper.Config;

public class Loadin {

    public static void load() {
        if (Config.createConfig("motd")) {
            Config.writeConfig("motd", "Maxplayers", 50000);
            Config.writeConfig("motd", "Description", "GameStom by HAPPYLAND-Dev");
        }
    }

}
