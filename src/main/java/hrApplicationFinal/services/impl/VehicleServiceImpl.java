package hrApplicationFinal.services.impl;

import hrApplicationFinal.domain.Vehicle;
import hrApplicationFinal.repositories.VehicleRepository;
import hrApplicationFinal.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer vehicleId) {
        return vehicleRepository.findOne(vehicleId);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable) {
        return vehicleRepository.save(vehicleIterable);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.delete(id);
    }
}
