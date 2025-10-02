// Imports ArrayList class
import java.util.ArrayList;

/**
 * The Train class implements the TrainRequirements interface. 
 * This class ties together the Passenger, Car, and Engine classes into a full train. 
 */
public class Train implements TrainRequirements{

    // Attributes
    private ArrayList<Car> Cars; 
    private Engine Engine; 

    /**
     * Constructor for Train class which initializes train with a Car and an Engine. 
     * @param fuelType The fuelType of the Engine
     * @param currentFuelLevel The currentFuelLevel of the Engine
     * @param fuelCapacity The maximum fuel capacity of the Engine
     * @param nCars The number of cars on the train 
     * @param passengerCapacity The maximum passenger capacity of each train car 
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) { 
        this.Cars = new ArrayList<Car>();
        for (int i=0; i<nCars; i++) {
            Car Car = new Car(passengerCapacity); 
            Cars.add(Car); 
        }
        this.Engine = new Engine(fuelType, currentFuelLevel, fuelCapacity); 
    }

    /**
     * Accessor for Engine attribute
     * @return the Engine of the train
     */
    public Engine getEngine() { 
        return this.Engine; 
    }

    /**
     * Accessor for a certain car of the train
     * @param i the index number of the car 
     * @return the Car object at the given index number 
     */
    public Car getCar(int i) { 
        return this.Cars.get(i); 
    }

    /**
     * Accessor for the maximum capacity of the train across all cars. 
     * @return maxCapacity of train across all cars
     */
    public int getMaxCapacity() { 
        int maxCapacity = 0; 
        for (int i=0; i<this.Cars.size(); i++) {
            maxCapacity += this.Cars.get(i).getCapacity(); 
        }
        return maxCapacity; 
    }

    /**
     * Calculates remaining open seats across all cars. 
     * @return the number of remaining open seats across all Cars
     */
    public int seatsRemaining() { 
        int seatsRemaining = 0; 
        for (int i=0; i<this.Cars.size(); i++) {
            seatsRemaining += this.Cars.get(i).seatsRemaining(); 
        }
        return seatsRemaining; 
    }

    /**
     * prints a roster of all Passengers onboard in each car
     */
    public void printManifest() {
        System.out.println("Train Manifest:");
        for (int i=0; i<this.Cars.size(); i++) {
            System.out.println("Car" + (i+1) + ": ");
            this.Cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        // Create a Train with 1 car, capacity 5, and an engine
        Train train = new Train(FuelType.ELECTRIC, 50.0, 100.0, 2, 5);

        // Access engine
        System.out.println("Engine fuel type: " + train.getEngine().getFuelType());
        System.out.println("Engine fuel level: " + train.getEngine().getCurrentFuel());
        System.out.println("Engine max capacity: " + train.getEngine().getMaxFuel());

        // Refuel train
        System.out.println("Train refuelling...");
        train.getEngine().refuel();
        System.out.println("Train refuelled!");
        System.out.println("Engine fuel level: " + train.getEngine().getCurrentFuel());

        // Access cars
        Car firstCar = train.getCar(0);
        System.out.println("First car capacity: " + firstCar.getCapacity());
        System.out.println("Train Capacity: " + train.getMaxCapacity());
        System.out.println("Seats remaining: " + train.seatsRemaining());

        // Add some passengers 
        System.out.println("Boarding...");
        Passenger alice = new Passenger("Alice");
        Passenger beatrice = new Passenger("Beatrice");
        alice.boardCar(firstCar);
        beatrice.boardCar(firstCar);

        // Check seats
        System.out.println("Seats remaining after boarding: " + train.seatsRemaining());

        // Print manifest
        train.printManifest();

        // Board second car
        Car secondCar = train.getCar(1);
        System.out.println("Second car capacity: " + secondCar.getCapacity());
        System.out.println("Boarding...");
        Passenger catherine = new Passenger("Catherine"); 
        Passenger diana = new Passenger("Diana"); 
        catherine.boardCar(secondCar);
        diana.boardCar(secondCar);

        // Check seats
        System.out.println("Seats remaining after boarding: " + train.seatsRemaining());

        // Print manifest
        train.printManifest();

    }
}
