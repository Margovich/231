package web.service;

import org.springframework.ui.ModelMap;
import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getList();
    List<Car> getCars(int count);
    String printCars(int count, ModelMap model);
}
