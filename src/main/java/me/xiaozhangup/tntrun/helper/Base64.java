package me.xiaozhangup.tntrun.helper;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Base64 {

        public static String decodeBase64(File file)
    {
        FileInputStream fis;
        try
        {
            fis = new FileInputStream(file);
            byte[] imageBytes = new byte[(int)file.length()];
            fis.read(imageBytes);
            fis.close();
            return DatatypeConverter.printBase64Binary(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
