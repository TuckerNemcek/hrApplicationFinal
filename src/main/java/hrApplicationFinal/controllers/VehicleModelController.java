package hrApplicationFinal.controllers;

import hrApplicationFinal.services.VehicleModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    private Logger log = Logger.getLogger(VehicleModelController.class);

    @RequestMapping(value ="/VehicleModels/List", method = RequestMethod.GET)
    public String vehicleModelList(Model model) {
        model.addAttribute("listAllVehicleModels", vehicleModelService.listAllVehicleModels());
        return "vehicleModels/vehicleModelList";
    }
}
