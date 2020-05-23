package nl.zdzislaw.verhuur_voertuig.model.Assortment;

import net.minidev.json.JSONUtil;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.*;

@Entity
@DiscriminatorValue("auto")
public class Auto extends Vehicle {
    @Column(name = "IsAirConditioning")
    private boolean isAirConditioning;
    @Column(name = "IsManualTransmission")
    private boolean isManualTransmission;
    @Column(name = "NumberOfDoors")
    private int numberOfDoors;

    public boolean getIsAirConditioning() {
        return isAirConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        isAirConditioning = airConditioning;
    }

    public boolean getIsManualTransmission() {
        return isManualTransmission;
    }

    public void setManualTransmission(boolean manualTransmission) {
        isManualTransmission = manualTransmission;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Auto(String vehicleName,  int engineCapacity, int numberOfSeats, double pricePerDay, String fuelType, String sourceImage, boolean isAirConditioning, boolean isManualTransmission, int numberOfDoors) {
        super(vehicleName,  engineCapacity, numberOfSeats, pricePerDay, fuelType, sourceImage);
        this.isAirConditioning = isAirConditioning;
        this.isManualTransmission = isManualTransmission;
        this.numberOfDoors = numberOfDoors;
    }

    public Auto() {
    }

    @Override
    public String toString() {
        return "Auto{" +
                "isAirConditioning=" + isAirConditioning +
                ", isManualTransmission=" + isManualTransmission +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}
