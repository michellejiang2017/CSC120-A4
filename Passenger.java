import java.util.ArrayList;

public class Passenger {
    //The Passenger class (Passenger.java) will store information about an individual passenger
    // assoc cars & train 
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() { 
        return this.name; 
    }

    public void boardCar(Car c) {
        if (c.addPassenger(this)) {
            c.addPassenger(this); // does this make sense? 
        } 
    }

    public void getOffCar(Car c) {
        if (c.removePassenger(this)) { 
            c.removePassenger(this); 
        }
    }

    public static void main(String[] args) {
        Passenger passenger = new Passenger("Alice"); 
        Passenger passenger2 = new Passenger("Beatrice"); 
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(passenger); 
        passengers.add(passenger2);
        Car myCar = new Car(passengers, 100); 
        myCar.seatsRemaining(); 
        myCar.getCapacity(); 
        myCar.printManifest();
    }
}
