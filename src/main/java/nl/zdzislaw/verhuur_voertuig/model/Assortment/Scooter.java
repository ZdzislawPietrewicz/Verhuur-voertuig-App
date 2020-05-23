package nl.zdzislaw.verhuur_voertuig.model.Assortment;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("scooter")
public class Scooter extends Vehicle {
    @Column(name = "MaxSpeed")
    private int maxSpeed;
    @Column(name = "HelmentObligation")
    private boolean helmentObligation;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isHelmentObligation() {
        return helmentObligation;
    }

    public void setHelmentObligation(boolean helmentObligation) {
        this.helmentObligation = helmentObligation;
    }



    public Scooter() {
    }
}
