package nl.zdzislaw.verhuur_voertuig.repository;

import nl.zdzislaw.verhuur_voertuig.model.Assortment.Auto;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    List<Vehicle> findAll();
}
