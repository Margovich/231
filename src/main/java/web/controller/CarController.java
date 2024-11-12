package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {

        List<web.model.Car> carList;

        if (count >= 5){
            carList = carService.getCars(Integer.MAX_VALUE);
        } else {
            carList = (count >= 0) ? carService.getCars(count) : carService.getCars(-1);
        }
        model.addAttribute("cars", carList);
        return "cars";
    }
}