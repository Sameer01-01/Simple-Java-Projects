import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String carid;
    private String brand;
    private String model;
    private double basepriceperday;
    private boolean isavailible;

    public Car(String carid, String brand, String model, Double basepriceperday) {
        this.carid = carid;
        this.brand = brand;
        this.model = model;
        this.basepriceperday = basepriceperday;
        this.isavailible = true;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculateprice(int rentaldays){
        return basepriceperday*rentaldays;
    }

    public boolean isavailible(){
        return isavailible;
    }

    public void rent(){
        isavailible=false;
    }

    public void returncar(){
        isavailible = true;
    }





}


public class CarRental {
    public static void main(String[] args) {
        Car car1 = new Car("1", "Toyota", "Corolla", 50.0);
        System.out.println("Brand: " + car1.getBrand());
        System.out.println("Model: " + car1.getModel());
    }
}
