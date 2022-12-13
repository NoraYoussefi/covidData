package fr.ubo.controllers;

import fr.ubo.beans.CovidData;
import fr.ubo.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * this is the controller of our project
 */
@RestController
//@RequestMapping(value = "/test")
public class CovidController {

    @Autowired
    private CovidService covidService;

    CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/ListData/{pays}")
     List<CovidData> ListData(@PathVariable String pays) {
        return covidService.showOneCountryData(pays);
    }

    @GetMapping("/ListDataByDate/{pays}/{date}")
    List<CovidData> ListDataByDate(@PathVariable String pays,@PathVariable String date) {
        return covidService.showOneCountryDataByDate(pays,date);
    }

    @GetMapping("/ListDataByCurrentDate/{pays}")
    List<CovidData> ListDataByCurrentDate(@PathVariable String pays) {
        return covidService.showOneCountryDataCurrentDate(pays);
    }

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
