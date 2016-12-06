import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
 
/**
 * A utility class that reads/saves SMTP settings from/to a properties file.
 * @author www.codejava.net
 *
 */
public class ConfigUtility {
    private File configFile = new File("smtp.properties");
    private Properties configProps;
    private String uHost, uEmail, uPassword; 
    
    public ConfigUtility(String uHost, String uEmail, String uPassword){
    	this.uHost = uHost;
    	this.uEmail = uEmail;
    	this.uPassword = uPassword;
    }
    
    public Properties loadProperties(String uHost, String uEmail, String uPassword) throws IOException {
        Properties defaultProps = new Properties();
        // sets default properties "smtp.gmail.com" "tom@gmail.com" "secret"
        defaultProps.setProperty("mail.smtp.host", uHost);
        defaultProps.setProperty("mail.smtp.port", "587");
        defaultProps.setProperty("mail.user", uEmail);
        defaultProps.setProperty("mail.password", uPassword);
        defaultProps.setProperty("mail.smtp.starttls.enable", "true");
        defaultProps.setProperty("mail.smtp.auth", "true");
         
        configProps = new Properties(defaultProps);
         
        // loads properties from file
        if (configFile.exists()) {
            InputStream inputStream = new FileInputStream(configFile);
            configProps.load(inputStream);
            inputStream.close();
        }else{
        	OutputStream outputStream = new FileOutputStream(configFile);
            configProps.store(outputStream, "host setttings");
            outputStream.close();
        }
         
        return configProps;
    }
     
    public void saveProperties(String host, String port, String user, String pass) throws IOException {
        configProps.setProperty("mail.smtp.host", host);
        configProps.setProperty("mail.smtp.port", port);
        configProps.setProperty("mail.user", user);
        configProps.setProperty("mail.password", pass);
        configProps.setProperty("mail.smtp.starttls.enable", "true");
        configProps.setProperty("mail.smtp.auth", "true");
         
        OutputStream outputStream = new FileOutputStream(configFile);
        configProps.store(outputStream, "host setttings");
        outputStream.close();
    }  
}