package property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

    static FileInputStream fis;
    static Properties prop = new Properties();
    public static String readFromPropFile(String key) {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/properties/TrelloAPIs.property");
            prop.load(fis);
            return prop.getProperty(key).trim();
        } catch(IOException ex) { ex.printStackTrace(); }

        return null;
    }

    public static void writeToPropFile(String key, String value) {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/properties/TrelloAPIs.property");
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/properties/TrelloAPIs.property");
            prop.load(fis);
            prop.setProperty(key, value);
            prop.store(fos, "Flush");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
