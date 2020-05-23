package nl.zdzislaw.verhuur_voertuig.service;

import nl.zdzislaw.verhuur_voertuig.model.Assortment.Auto;
import nl.zdzislaw.verhuur_voertuig.model.Assortment.Vehicle;
import nl.zdzislaw.verhuur_voertuig.repository.VehicleRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
@Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void addVehicle(Vehicle vehicle){
    vehicleRepository.save(vehicle);
    }

    public List<Vehicle> showAllVehicles(){
    List<Vehicle>listAllVehicles=vehicleRepository.findAll();
    return  listAllVehicles;
    }
}
