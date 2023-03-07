package utils;

import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static final String propertiesPath="common.properties";

    private static final Properties commonPropertiesFile = loadCommonPropertiesFile();

    public static Properties loadPropertiesFile(String filePath){
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(filePath);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        }catch (IOException e){
            Assert.fail("Cannot load "+filePath+" file! Message "+e.getMessage());
        }
        return properties;
    }

    private static Properties loadCommonPropertiesFile(){
        return loadPropertiesFile(propertiesPath);
    }

    private static String getProperty(String property){
        String result = commonPropertiesFile.getProperty(property);
        Assert.assertNotNull(result, "Cannot find property '"+property+"' in "+propertiesPath+" file!!!");
        return result;
    }
    public static String getEnvironment(){
        return getProperty("environment");
    }
    public static String getProdUrl(){
        return getProperty("prodUrl");
    }
    public static String getBrowser(){
        return getProperty("browser");
    }
    public static boolean getHeadless(){
        return Boolean.parseBoolean(getProperty("headless"));
    }
    public static String getDriversFolder(){
        return getProperty("driversFolder");
    }





}
