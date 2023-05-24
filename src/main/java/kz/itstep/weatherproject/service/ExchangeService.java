package kz.itstep.weatherproject.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExchangeService {
    private final String API_KEY="1fa880ba1a5a4ab5ac29f284e94855f2";
    private final WebClient exchangeClient;

    public ExchangeService(WebClient exchangeClient) {
        this.exchangeClient = exchangeClient;
    }

    public String getExchangeValute(Double sum, String val){
        JsonNode jsonNode = exchangeClient.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParam("app_id", API_KEY).build())
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        double valD = jsonNode.get("rates").get(val).asDouble() * sum;

        return Double.toString(valD);
    }
}
