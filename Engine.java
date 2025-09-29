public class Engine implements EngineRequirements{
    //The Engine class (Engine.java) will represent the locomotive engine, storing information about its fuel type, level, etc.
    // train agg & use fuel type 

    private FuelType fuelType; 
    private double currentFuelLevel; 
    private double maxFuelLevel; 

    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = 5; 
        this.maxFuelLevel = 10; 
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public double getMaxFuel() {
        return maxFuelLevel; 
    }

    public double getCurrentFuel() {
        return currentFuelLevel; 
    }

    public void refuel() {
        currentFuelLevel = maxFuelLevel; 
    }

    public Boolean go() {
        while (currentFuelLevel > 0) {
            currentFuelLevel--; 
            return true;  
        } return false; 
        
    }


   public static void main(String[] args) {
       Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
       while (myEngine.go()) {
           System.out.println("Choo choo!");
       }
       System.out.println("Out of fuel.");
   }
}