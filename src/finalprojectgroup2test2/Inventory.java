package finalprojectgroup2test2;
import dto.Vehicle;

import java.util.ArrayList;

public class Inventory  {
    private ArrayList<Vehicle> vehiclesCollection;
    private String Dealerid;

    public Inventory(String Dealerid) {
    	this.Dealerid = Dealerid;
    	
        vehiclesCollection = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehiclesCollection;
    }

    public void setVehicles(ArrayList<Vehicle> vehiclesCollection) {
        this.vehiclesCollection = vehiclesCollection;
    }


    public void add(Vehicle o) {
        vehiclesCollection.add(o);
    }

    public Vehicle getVehicle(int index){
        return vehiclesCollection.get(index);
    }
    
	public static void main(String[] args) {
	}
	
}