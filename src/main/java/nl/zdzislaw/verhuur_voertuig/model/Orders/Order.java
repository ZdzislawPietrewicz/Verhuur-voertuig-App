package nl.zdzislaw.verhuur_voertuig.model.Orders;




import nl.zdzislaw.verhuur_voertuig.model.Assortment.Extras;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int OrderID;
    private LocalDateTime orderDate;
    private double totalPrice;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Extras>accessories;

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    public void addAccessory(Extras extras){
        this.accessories.add(extras);
    }
}