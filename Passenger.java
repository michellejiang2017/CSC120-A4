/**
 * The Passenger class implements the PassengerRequirements interface. 
 * The Passenger class stores information about an individual passenger
 */
public class Passenger implements PassengerRequirements{

    // Attributes
    private String name;

    /**
     * Constructor for Passenger class 
     * @param name initializes name of passenger 
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Accessor for name attribute
     * @return name of passenger 
     */
    public String getName() { 
        return this.name; 
    } 

    /**
     * calls addPassenger from Car class to board a given car. 
     * Checks the value that gets returned by c.addPassenger(...) in case the selected car is full.
     * @param c Car that the passenger wants to board 
     */
    public void boardCar(Car c) {
        boolean boarded = c.addPassenger(this);
        if (!boarded) {
            System.out.println("Could not board passenger: " + this); 
        } 
    }

    /**
     * calls removePassenger to get off a given Car. 
     * Checks the value that gets returned by c.removePassenger(...) in case the Passenger wasn't actually onboard.
     * @param c Car that the passenger wants to get off. 
     */
    public void getOffCar(Car c) {
        boolean removed = c.removePassenger(this); 
        if (!removed) { 
            System.out.println("Could not remove passenger: " + this);
        }
    }

    public static void main(String[] args) {

        // Creates passengers Alice and Beatrice & new car with capacity 100
        Passenger passenger = new Passenger("Alice"); 
        Passenger passenger2 = new Passenger("Beatrice"); 
        Car myCar = new Car(100); 

        // Boards passengers to car 
        passenger.boardCar(myCar);
        passenger2.boardCar(myCar);

        // Checks seats, capacity, and passengers 
        System.out.println(myCar.seatsRemaining()); 
        System.out.println(myCar.getCapacity());
        myCar.printManifest();

        // removes Alice & checks car
        passenger.getOffCar(myCar);
        myCar.printManifest();
    }
}
