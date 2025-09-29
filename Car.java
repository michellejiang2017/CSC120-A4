import java.util.ArrayList;

public class Car implements CarRequirements {
    //The Car class (Car.java) will be used as a container for Passenger objects
    // passengers assoc 
    // train agg

    private ArrayList<String> passenger; 
    private int carCapacity;
    
    public Car(ArrayList<String> passenger, int carMaxCapacity) {
        this.passenger = passenger; 
        this.carCapacity = carMaxCapacity; 
    }

    public int getCapacity() { 
        return carCapacity; 
    }

    public int seatsRemaining() { 
        return carCapacity - passenger.size(); 
    }

    
}