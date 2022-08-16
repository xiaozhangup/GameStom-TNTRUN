package me.xiaozhangup.tntrun.helper;

import me.xiaozhangup.tntrun.TNTRun;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class Files {


    public static String getPath() {
        URL url = TNTRun.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包含".jar"
            // 截取路径中的jar包名
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }

        File file = new File(filePath);

        filePath = file.getAbsolutePath();
        return filePath;
    }

    public static boolean createFile(String s) {
        File file = new File(Files.getPath(), s);
        try {
            boolean exists = file.createNewFile();
            return exists;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getFile(String s) {
        File file = new File(Files.getPath(), s);
        if (!file.exists()) {
            createFile(s);
        }
        return file;
    }

}
