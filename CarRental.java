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

    public String getcarid(){
        return carid;
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

class Customer{
    private String customerid;
    private String name;

    public Customer(String customerid, String name){
        this.customerid=customerid;
        this.name=name;
    }

    public String getcustomerid(){
        return customerid;
    }

    public String getname(){
        return name;
    }
}

class Rental{
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days){
        this.car=car;
        this.customer=customer;
        this.days=days;
    }

    public Car getcar(){
        return car;
    }

    public Customer getcustomer(){
        return customer;
    }

    public int getDays(){
        return days;
    }

}
class Carrentalsystem{
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public void addcar(){
        cars = new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }

    public void addcustomer(Customer customer){
        customers.add(customer);
    }

    public void rentcar(Car car, Customer customer, int days){
        if(car.isavailible()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else{
            System.out.println("Car not available for rent.");
        }
    }

    public void returncar(Car car){
        car.returncar();
        Rental rentaltoremove=null;
        for(Rental rental:rentals){
            if(rental.getcar()==car){
                rentaltoremove=rental;
                break;
            }
        }
        if (rentaltoremove!=null){
            rentals.remove(rentaltoremove);
        }
        else{
            System.out.println("Car was not rented.");
        }
    }

    public void menu(){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("CAR RENTAL SYSTEM.");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice==1){
                System.out.println("Enter your name :- ");
                String customername=scanner.nextLine();

                System.out.println("Available Cars :- ");
                for (Car car:cars){
                    if (car.isavailible()){
                        System.out.println(car.getcarid()+"-"+car.getBrand()+""+car.getModel());
                    }
                }
                System.out.println("Enter the car id you want to rent :- ");
                String carid= scanner.nextLine();

                System.out.println("Enter the number of days for rental :-");
                int rentaldays=scanner.nextInt();
                scanner.nextLine();

                 Customer newCustomer = new Customer("CUS"+(customers.size()+1),customername);
                 addcustomer(newCustomer);

                 Car selectedCar=null;
                 for(Car car:cars){
                    if(car.getcarid().equals(carid)&&car.isavailible()){
                        selectedCar=car;
                        break;
                    }
                 }

                 if (selectedCar!=null){
                    double totalprice= selectedCar.calculateprice(rentaldays);
                    System.out.println("RENTAL INFORMATION.");
                    System.out.println("Customer ID: "+ newCustomer.getname());
                    System.out.println("Car :- "+selectedCar.getBrand()+" "+ selectedCar.getModel());
                    System.out.println("Rental Days : "+rentaldays);
                    System.out.println("Total Price :- $%.2f%n"+totalprice);

                    System.out.println("confirm rental (Y/N)");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")){
                        rentcar(selectedCar, newCustomer, rentaldays);
                        System.out.println("Car rented successfully.");
                    }
                    else{
                        System.out.println("Rental cancelled.");
                    }
                 }  
                 else{
                    System.out.println("invalid car selection or car not available for rent.");
                 }
            }
            else if (choice==2){
                System.out.println("Enter the carid you want to return :- ");
                String carid=scanner.nextLine();

                Car cartoreturn=null;
                for (Car car:cars){
                    if (car.getcarid().equals(carid)&& !car.isavailible()){
                        cartoreturn=car;
                        break;
                    }
                }
                if (cartoreturn!=null){
                    Customer customer=null;
                    for(Rental rental : rentals){
                        if (rental.getcar()==cartoreturn){
                            customer=rental.getcustomer();
                            break;
                        }
                    }
                    if(customer!=null){
                        returncar(cartoreturn);
                        System.out.println("Car was successfully returned by "+customer.getname());
                    }
                    else{
                        System.out.println("Invalid car ID or car is not rented.");
                    }
                }
                
            }
            else if(choice==3){
                break;
            }
            else{
                System.out.println("Invalid choice. Please enter a valid option.");
            }
            
        }
        System.out.println("Thank you for using the car rental system!!!");
    }

    
}




public class CarRental {
    public static void main(String[] args) {
        
    }
}
