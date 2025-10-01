import java.util.ArrayList;

public class Train {
/*  and the Train (Train.java) class will tie them all together.
engine agg 
cars agg
passengers assoc
*/
    private ArrayList<Car> Cars; 
    private Engine Engine; 

    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) { 
        Car Car = new Car(passengerCapacity); 
        this.Cars = new ArrayList<Car>();
        Cars.add(Car); 
        this.Engine = new Engine(fuelType, currentFuelLevel, fuelCapacity); 
    }

    public Engine getEngine() { 
        return this.Engine; 
    }

    public Car getCar(int i) { 
        return this.Cars.get(i); 
    }

    public int getMaxCapacity() { 
        int maxCapacity = 0; 
        for (int i=0; i<this.Cars.size(); i++) {
            maxCapacity += this.Cars.get(i).getCapacity(); 
        }
        return maxCapacity; 
    }

    public int seatsRemaining() { 
        int seatsRemaining = 0; 
        for (int i=0; i<this.Cars.size(); i++) {
            seatsRemaining += this.Cars.get(i).seatsRemaining(); 
        }
        return seatsRemaining; 
    }

    public void printManifest() {
        for (int i=0; i<this.Cars.size(); i++) {
            this.Cars.get(i).printManifest();
        }
    }
}
