package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Audi", "red", 555));
        cars.add(new Car("Scoda", "black", 88));
        cars.add(new Car("Honda", "gray", 22));
        cars.add(new Car("BMW", "white", 666));
        cars.add(new Car("Ferrari", "red", 777));
    }

    @GetMapping(value = "/cars")
    public String getAllCars(@RequestParam(value = "count", required = false) String count, Model model) {
        List<Car> cars2 = cars.stream().limit(Long.parseLong(count)).toList();
        model.addAttribute("cars", cars2);
        return "cars";

    }

}