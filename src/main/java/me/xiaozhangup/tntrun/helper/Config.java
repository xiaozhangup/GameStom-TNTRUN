package me.xiaozhangup.tntrun.helper;

import org.bspfsystems.yamlconfiguration.file.FileConfiguration;
import org.bspfsystems.yamlconfiguration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static boolean createConfig(String s) {
        File file = new File(Files.getPath(), s + ".yml");
        try {
            boolean exists = file.createNewFile();
            return exists;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileConfiguration getConfig(String s) {
        File file = new File(Files.getPath(), s + ".yml");
        if (!file.exists()) {
            createConfig(s);
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void writeConfig(String s, String node, Object value) {
        FileConfiguration fileConfiguration = getConfig(s);
        fileConfiguration.set(node, value);
        try {
            fileConfiguration.save(new File(Files.getPath(), s + ".yml"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
