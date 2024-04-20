package br.com.configcat.example.demo.service;

import br.com.configcat.example.demo.exception.IntegrationException;
import com.configcat.ConfigCatClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConfigCatService {

    private final ConfigCatClient configCatClient;

    public static final String FT_TESTE = "ft_teste";

    public <T> T findFlag(Class<T> responseType, String keyFlag, T defaultValue) {
        try {
            configCatClient.forceRefresh();
            return configCatClient.getValue(responseType, keyFlag, defaultValue);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao consultar a flag no ConfigCat. " + e.getMessage());
            throw new IntegrationException("Ocorreu um erro ao consultar a flag no ConfigCat. " + e.getMessage());
        }
    }

}
