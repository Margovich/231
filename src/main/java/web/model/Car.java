package web.model;

import java.util.Objects;

public class Car {

    private String model;
    private String color;
    private int year;

    public Car (String model, String color, int year){
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public Car (){
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return model + " " + color + " " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(year, car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, year);
    }
}
