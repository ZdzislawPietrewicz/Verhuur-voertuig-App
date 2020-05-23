package nl.zdzislaw.verhuur_voertuig.model.Assortment;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bus")
public class Bus extends Vehicle {
    @Column(name = "IsAirConditioning")
    private boolean isAirConditioning;
    @Column(name="IsManualTransmission")
    private boolean isManualTransmission;
    @Column(name = "NumberOfDoors")
    private int numberOfDoors;
    @Column (name = "CabinLength")
    private double cabinLength;
    @Column (name = "CabinWidth")
    private double cabinWidth;
    @Column (name = "CabinHeight")
    private double cabinHeight;

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

    public double getCabinLength() {
        return cabinLength;
    }

    public void setCabinLength(double cabinLength) {
        this.cabinLength = cabinLength;
    }

    public double getCabinWidth() {
        return cabinWidth;
    }

    public void setCabinWidth(double cabinWidth) {
        this.cabinWidth = cabinWidth;
    }

    public double getCabinHeight() {
        return cabinHeight;
    }

    public void setCabinHeight(double cabinHeight) {
        this.cabinHeight = cabinHeight;
    }

    public Bus(String vehicleName, int engineCapacity, int numberOfSeats, double pricePerDay, String fuelType, String sourceImage, boolean isAirConditioning, boolean isManualTransmission, int numberOfDoors, double cabinLength, double cabinWidth, double cabinHeight) {
        super(vehicleName, engineCapacity, numberOfSeats, pricePerDay, fuelType, sourceImage);
        this.isAirConditioning = isAirConditioning;
        this.isManualTransmission = isManualTransmission;
        this.numberOfDoors = numberOfDoors;
        this.cabinLength = cabinLength;
        this.cabinWidth = cabinWidth;
        this.cabinHeight = cabinHeight;
    }

    public Bus() {
    }
}
