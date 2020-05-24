package nl.zdzislaw.verhuur_voertuig.model.Assortment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Extras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ExtrasID")
    private int extrasID;
    @Column(name="Description")
    private String description;
    @Column(name = "PricePerDAy")
    private double pricePerDay;

    public int getExtrasID() {
        return extrasID;
    }

    public void setExtrasID(int extrasID) {
        this.extrasID = extrasID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Extras(String description, double pricePerDay) {
        this.description = description;
        this.pricePerDay = pricePerDay;
    }

    public Extras() {
    }

    @Override
    public String toString() {
        return "Extras{" +
                "extrasID=" + extrasID +
                ", description='" + description + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
