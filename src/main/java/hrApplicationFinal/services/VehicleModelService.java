package hrApplicationFinal.services;

import hrApplicationFinal.domain.VehicleModel;

public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModels();

    VehicleModel getVehicleModelById(Integer veModelId);

    VehicleModel saveVehicleModel (VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModelList (Iterable<VehicleModel> vehicleModelIterable);

    void deleteVehicleModel(Integer id);
}
