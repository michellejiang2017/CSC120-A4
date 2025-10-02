/**
 * Engine class which implements EngineRequirements interface. 
 * The Engine class (Engine.java) will represent the locomotive engine, storing information about its fuel type, level, etc.
 * Date: 2025-10-02
 * @author Michelle Jiang
 */
public class Engine implements EngineRequirements{

    // Attributes
    private FuelType fuelType; 
    private double currentFuelLevel; 
    private double maxFuelLevel; 
/**
 * Constructor which initializes Engine class 
 * @param fuelType the type of fuel the engine runs on
 * @param currentFuelLevel the current level of fuel 
 * @param maxFuelLevel the maximum capacity of fuel the engine can hold
 */
    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel; 
        this.maxFuelLevel = maxFuelLevel; 
    }

    /**
     * Accessor for fuelType attribute
     * @return fuelType of engine which can be STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Accessor for maxFuelLevel attribute 
     * @return maxFuelLevel of engine's capacity
     */
    public double getMaxFuel() {
        return maxFuelLevel; 
    }

    /**
     * Accessor for currentFuelLevel attribute
     * @return currentFuelLevel of the engine 
     */
    public double getCurrentFuel() {
        return currentFuelLevel; 
    }

    /**
     * Resets the currentFuelLevel to the maxFuelLevel
     */
    public void refuel() {
        currentFuelLevel = maxFuelLevel; 
    }

    /**
     * decrease the current fuel level
     * prints remaining fuel level
     * @return True if the fuel level is above 0 and False otherwise.
     */
    public Boolean go() {
        while (currentFuelLevel > 0) {
            currentFuelLevel--; 
            String fuelLevel = String.valueOf(currentFuelLevel); 
            System.out.println("Fuel Level:" + fuelLevel);
            return true;  
        } return false; 
        
    }

    // Testing Engine code 
   public static void main(String[] args) {
       Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
       while (myEngine.go()) {
           System.out.println("Choo choo!");
       }
       System.out.println("Out of fuel.");
   }
}