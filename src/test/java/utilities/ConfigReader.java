package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //bu class configuration.properties dosyasındaki
    //bilgileri okumak icindir.

    //Properties data obje olusturduk
    private static Properties properties;

    static {
        //properties file path'i
        String path="configuration.properties";

        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            //properties objeyi aktif et/calistir.
            properties=new Properties();

            //dosyayı yukle-oku
            properties.load(fileInputStream);

            //dosyayı kapat
            fileInputStream.close();

        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    //getProperty(key--value)
    public static String getProperty(String key){
       String value=properties.getProperty(key);
       return value;
        // return properties.getProperty(key);
    }
}
