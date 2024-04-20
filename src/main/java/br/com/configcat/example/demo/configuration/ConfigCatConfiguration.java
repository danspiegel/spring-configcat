package br.com.configcat.example.demo.configuration;

import com.configcat.ConfigCache;
import com.configcat.ConfigCatClient;
import com.configcat.LogLevel;
import com.configcat.PollingModes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCatConfiguration {

    @Value("${configCat.key}")
    private String key;

    @Bean
    public ConfigCatClient configCatClient() {
        ConfigCatClient client = ConfigCatClient.get(key, options -> {
            options.pollingMode(PollingModes.manualPoll());
        });
        return client;
    }

}
