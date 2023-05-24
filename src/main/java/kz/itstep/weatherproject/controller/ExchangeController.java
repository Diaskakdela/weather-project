package kz.itstep.weatherproject.controller;

import kz.itstep.weatherproject.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/{valute}")
    public ResponseEntity<String> getExchangeValue(@RequestParam Double sum, @PathVariable String valute){

        return ResponseEntity.ok(exchangeService.getExchangeValute(sum, valute));
    }
}
