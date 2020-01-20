package hrApplicationFinal.controllers;

import hrApplicationFinal.domain.VO.VehicleMakeVO;
import hrApplicationFinal.domain.VO.VehicleModelVO;
import hrApplicationFinal.domain.VehicleMake;
import hrApplicationFinal.domain.VehicleModel;
import hrApplicationFinal.services.VehicleMakeService;
import hrApplicationFinal.services.VehicleModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    private Logger log = Logger.getLogger(VehicleModelController.class);

    @RequestMapping(value ="/VehicleModels/List", method = RequestMethod.GET)
    public String vehicleModelList(Model model) {
        model.addAttribute("listAllVehicleModels", vehicleModelService.listAllVehicleModels());
        return "vehicleModels/vehicleModelList";
    }

    @RequestMapping(value = "/VehicleModels/Add", method = RequestMethod.GET)
    public String vehicleModelAdd(Model model, VehicleModelVO vehicleModelVO)  {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "vehicleModels/vehicleModelAdd";
    }

    @RequestMapping(value = "/VehicleModels/Add", method = RequestMethod.POST)
    public String vehicleModelAddPost(Model model, VehicleModelVO vehicleModelVO){
        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleModelName(vehicleModelVO.getNewVehicleModelName());
        vehicleModel.setVeModelId((vehicleModelVO.getId()));
        vehicleModel.setVehicleMake(vehicleModelVO.getVehicleMake());
        vehicleModelService.saveVehicleModel(vehicleModel);

        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "vehicleModels/vehicleModelAdd";
    }

}
