package kz.itstep.weatherproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WeatherConfig {

    @Bean
    public WebClient openWeatherClient(){
        return WebClient.create("http://api.openweathermap.org/data/2.5/");
    }

    @Bean
    public WebClient exchangeClient(){
        return WebClient.create("https://openexchangerates.org/api/latest.json");
    }
}
