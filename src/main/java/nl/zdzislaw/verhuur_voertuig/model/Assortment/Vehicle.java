package nl.zdzislaw.verhuur_voertuig.model.Assortment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeOfVehicle",discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "VehicleID")
    private int vehicleID;
    @Column(name = "VehicleName")
    private String vehicleName;
    @Column(name = "EngineCapacity")
    private int engineCapacity;
    @Column(insertable = false, updatable = false)
    private String typeOfVehicle;
    @Column(name = "NumberOfSeats")
    private int numberOfSeats;
    @Column(name = "PricePerDay")
    private double pricePerDay;
    @Column(name = "FuelType")
    private String fuelType;
    @Column(name="SourceImage")
    private String sourceImage;

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }

    public Vehicle(String vehicleName, int engineCapacity, int numberOfSeats, double pricePerDay, String fuelType, String sourceImage) {
        this.vehicleName = vehicleName;
        this.engineCapacity = engineCapacity;
        this.numberOfSeats = numberOfSeats;
        this.pricePerDay = pricePerDay;
        this.fuelType = fuelType;
        this.sourceImage=sourceImage;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", vehicleName='" + vehicleName + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", numberOfSeats=" + numberOfSeats +
                ", pricePerDay=" + pricePerDay +
                ", fuelType='" + fuelType + '\'' +
                ", sourceImage='" + sourceImage + '\'' +
                '}';
    }
}
