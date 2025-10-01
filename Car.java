import java.util.ArrayList;

public class Car implements CarRequirements {
    //The Car class (Car.java) will be used as a container for Passenger objects
    // passengers assoc 
    // train agg

    private ArrayList<Passenger> passenger; 
    private int carCapacity;
    
    public Car(ArrayList<Passenger> passenger, int carMaxCapacity) {
        this.passenger = passenger; 
        this.carCapacity = carMaxCapacity; 
    }

    public int getCapacity() { 
        return carCapacity; 
    }

    public int seatsRemaining() { 
        return carCapacity - passenger.size(); 
    }

    public Boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0 && passenger.contains(p)) {
            passenger.add(p); 
            return true; 
        } else { 
            return false; 
        }
    }

    public Boolean removePassenger(Passenger p) {
        if (seatsRemaining() > 0 && passenger.contains(p)) {
            passenger.remove(p); 
            return true; 
        } else { 
            return false; 
        }
    }

    public void printManifest() {
        if (passenger.size() > 0) { 
            for (int i=0; i<passenger.size(); i++) {
                System.out.println(passenger.get(i).getName());
            }
        } else {
            System.out.println("This car is EMPTY.");
        }
    }
}