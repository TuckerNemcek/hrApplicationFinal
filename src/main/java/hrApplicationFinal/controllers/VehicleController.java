package hrApplicationFinal.controllers;

import hrApplicationFinal.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    private Logger log = Logger.getLogger(VehicleController.class);

    @RequestMapping(value = "/Vehicles/List" , method = RequestMethod.GET)
    public String vehicleList(Model model) {
        model.addAttribute("listAllVehicles", vehicleService.listAllVehicles());
        return "vehicles/vehicleList";
    }

}
