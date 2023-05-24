package kz.itstep.weatherproject.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final WebClient openWeatherClient;
    private final String apiKey = "3ee1f26e5f4dea1fbfe1eb03204bffaf";

    public WeatherService(WebClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
    }

    public String findWeatherByCityName(String city){
        return fetchWeatherByCityName(city);
    }
    private String fetchWeatherByCityName(String city){
        JsonNode jsonNode = openWeatherClient.get().uri(uriBuilder -> uriBuilder
                        .path("weather")
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric")
                        .build())
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        StringBuilder stringBuilder = new StringBuilder();

        if(jsonNode!=null) {
            stringBuilder.append("City name = ").append(jsonNode.get("name").asText()).append("\n");
            stringBuilder.append(jsonNode.get("weather").get(0).get("main").asText()).append("\n");
            stringBuilder.append("temp= ").append(jsonNode.get("main").get("temp").asDouble());
        }

        return stringBuilder.toString();
    }
}
