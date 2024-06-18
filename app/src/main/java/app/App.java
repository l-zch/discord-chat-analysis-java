/*
 * This source file was generated by the Gradle 'init' task
 */
package app;

import java.io.File;
import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

class Config {
    public String botToken;
}

public class App {
    static Config config;

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File configFile = new File("src/config.json");
            if (!configFile.exists()) {
                System.out.println("config file not found. create a new one");
                configFile.createNewFile();
                FileWriter writer = new FileWriter(configFile);
                writer.write("{ \"botToken\" : \"put your bot token here\" }");
                writer.close();
                System.out.println("config file created. check out " + configFile.getAbsolutePath());
                return;
            }
            config = mapper.readValue(new File("src/config.json"), Config.class);
            SlashBot slashBot = new SlashBot(config.botToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}