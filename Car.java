// Imports ArrayList class
import java.util.ArrayList;

/**
 * Car class which implements CarRequirements interface. 
 * Simulates a car of a train which has passengers and max capacity. Used as a container for Passenger objects. 
 */
public class Car implements CarRequirements {

    // Attributes
    private ArrayList<Passenger> passenger; 
    private int carCapacity;
    
    /** 
     * Constructor which initializes Car class
     * @param carMaxCapacity the maximum number of passengers the car can hold
     */
    public Car (int carMaxCapacity) {
        this.carCapacity = carMaxCapacity; 
        this.passenger = new ArrayList<Passenger>(); 
    }

    /**
     * Accessor for carCapacity
     * @return carCapacity which is the car's maximum number of passengers 
     */
    public int getCapacity() { 
        return carCapacity; 
    }

    /**
     * Calculates the number of seats remaining in the train car
     * @return difference between the car's max capacity and the current number of passengers
     */
    public int seatsRemaining() { 
        return carCapacity - passenger.size(); 
    }

    /**
     * Adds passenger to car. Checks if seats are available and if passenger is not already on car. 
     * @param p passenger which is added to car 
     * @return true if operation is successful and false otherwise
     */
    public Boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0 && !passenger.contains(p)) {
            passenger.add(p); 
            return true; 
        } else { 
            return false; 
        }
    }

    /**
     * Removes passenger from car. Checks if passenger is on car first. 
     * @param p passenger which is removed from car
     * @return true if operation is successful and false otherwise
     */
    public Boolean removePassenger(Passenger p) {
        if (passenger.contains(p)) {
            passenger.remove(p); 
            return true; 
        } else { 
            return false; 
        }
    }

    /** 
     * prints out a list of all Passengers aboard the car (or "This car is EMPTY." if there is no one on board).
     */
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