package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private Properties props;
    public Properties init_properties(){

        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
            props.load(fis);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return props;

    }

}
