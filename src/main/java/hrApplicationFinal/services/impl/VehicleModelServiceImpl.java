package hrApplicationFinal.services.impl;

import hrApplicationFinal.domain.VehicleModel;
import hrApplicationFinal.repositories.VehicleModelRepository;
import hrApplicationFinal.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<VehicleModel> listAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer veModelId) {
        return vehicleModelRepository.findOne(veModelId);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable) {
        return vehicleModelRepository.save(vehicleModelIterable);
    }

    @Override
    public void deleteVehicleModel(Integer id) {
        vehicleModelRepository.delete(id);
    }


}
