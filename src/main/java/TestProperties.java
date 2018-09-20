import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 17.09.2018<br>
 * Time: 18:00<br>
 * todo javadoc
 */
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