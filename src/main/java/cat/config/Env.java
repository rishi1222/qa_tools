package cat.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by kaporis on 19/02/2018.
 */
public class Env {
    private static final Logger LOGGER = LogManager.getLogger(Env.class);
    public static final String PROPERTIES_FILE = "/test.properties";
    private Map<String, String> envMap = new HashMap<String, String>();

    private void loadProperties() {
        Properties properties = new Properties();

        try {
            properties.load(getClass().getResourceAsStream(PROPERTIES_FILE));
            copyToMap(properties);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }

    private void copyToMap(Properties properties) {
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            envMap.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public synchronized Map<String, String> getProperties() {
        if (envMap.isEmpty()) {
            loadProperties();
        }
        return envMap;
    }
}


