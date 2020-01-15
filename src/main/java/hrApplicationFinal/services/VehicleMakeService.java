package hrApplicationFinal.services;

import hrApplicationFinal.domain.VehicleMake;

public interface VehicleMakeService {

    Iterable<VehicleMake> listAllVehicleMakes();

    VehicleMake getVehicleMakeById(Integer veMakeId);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteVehicleMake(Integer id);

}
