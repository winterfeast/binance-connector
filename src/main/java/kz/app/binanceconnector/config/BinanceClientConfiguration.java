package kz.app.binanceconnector.config;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceClientConfiguration {

    @Bean
    public BinanceApiClientFactory binanceApiClientFactory(
            @Value("${binance.active-env}") String environment,
            @Value("${binance.api.key}") String apiKey,
            @Value("${binance.api.secret}") String secretKey
    ) {
        return switch (environment) {
            case "dev" -> BinanceApiClientFactory.newInstance(apiKey, secretKey, true, false);
            case "prod" -> BinanceApiClientFactory.newInstance(apiKey, secretKey);
            default -> throw new IllegalArgumentException("Invalid environment " + environment);
        };
    }

    @Bean
    public BinanceApiRestClient binanceApiRestClient(BinanceApiClientFactory binanceApiClientFactory) {
        return binanceApiClientFactory.newRestClient();
    }
}
