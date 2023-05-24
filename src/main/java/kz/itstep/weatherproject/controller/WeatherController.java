package kz.itstep.weatherproject.controller;

import kz.itstep.weatherproject.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeatherByCity(@PathVariable String city){
        return ResponseEntity.ok(weatherService.findWeatherByCityName(city));
    }

}
