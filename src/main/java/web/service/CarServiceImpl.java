package web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("Nine", "cherry", 1990));
        carList.add(new Car("Lada Sedan", "eggplant", 2010));
        carList.add(new Car("Boomer", "black", 1990));
        carList.add(new Car("tractor", "red", 2015));
        carList.add(new Car("Lada", "raspberry", 2020));
    }

    @Override
    public List<Car> getList() {
        return carList;
    }

    @Override
    public List<Car> getCars(int count) {
        return (count >= 0) ? getList().stream().limit(count).toList() : new ArrayList<>();
    }

    @Override
    public List<Car> printCars(int count) {
        List<web.model.Car> carList;
        if (count >= 5){
            carList = getCars(Integer.MAX_VALUE);
        } else {
            carList = (count >= 0) ? getCars(count) : getCars(-1);
        }
        return carList;
    }

}