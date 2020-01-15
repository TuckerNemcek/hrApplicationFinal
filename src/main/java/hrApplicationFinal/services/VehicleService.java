package hrApplicationFinal.services;

import hrApplicationFinal.domain.Vehicle;

public interface VehicleService {

    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer vehicleId);

    Vehicle saveVehicle (Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList (Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);

}
