package utilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public  static Properties properties;

    static { //static blok her method'dan once calisir.
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //fis dosya yolunu tanimladigimiz congiguration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis); //fis'in okudugu bilgileri properties'e yukledi
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static String getProperty(String key){
       /*
       test methodu'ndan yolladigimiz string key degerini alip Properties class'indan getProperty()
       method'unu kullnaran bu key'e ait valuyu bize getirir.
        */

       return properties.getProperty(key);

   }








}
