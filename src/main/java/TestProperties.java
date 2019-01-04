import java.io.*;
import java.util.*;


public class TestProperties {
    Properties properties = new Properties();
    FileInputStream fis;
    public TestProperties() {
        try {
            fis = new FileInputStream("config.properties");
            try {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}