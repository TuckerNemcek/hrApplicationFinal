package hrApplicationFinal.controllers;

import hrApplicationFinal.domain.VO.VehicleMakeVO;
import hrApplicationFinal.domain.VO.VehicleMakeVO;
import hrApplicationFinal.domain.VehicleMake;
import hrApplicationFinal.services.VehicleMakeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    private Logger log = Logger.getLogger(VehicleMakeController.class);

    @RequestMapping(value = "/VehicleMakes/Add", method = RequestMethod.GET)
    public String vehicleMakeAdd(Model model)    {
        model.addAttribute("vehicleMakeVO", new VehicleMakeVO());
        return "vehicleMakes/vehicleMakeAdd";
    }


    @RequestMapping(value = "/VehicleMakes/Add", method = RequestMethod.POST)
    public String vehicleMakePost(VehicleMakeVO vehicleMakeVO, Model model){
        logVehicleMakeVO(vehicleMakeVO);
        saveVehicleMakeFromVehicleMakeVO(vehicleMakeVO);
        return "vehicleMakes/vehicleMakeAdd";
    }

    @RequestMapping(value = "/VehicleMakes/List", method = RequestMethod.GET)
    public String vehicleMakeList(Model model) {
        model.addAttribute("listAllVehicleMakes", vehicleMakeService.listAllVehicleMakes());
        return "vehicleMakes/vehicleMakeList";
    }

    @RequestMapping(value = "/VehicleMakes/Edit/{id}", method = RequestMethod.GET)
    public String vehicleMakeEdit(@PathVariable int id, Model model) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);

        model.addAttribute("vehicleMake", vehicleMake);
        return "vehicleMakes/vehicleMakeEdit";
    }



//    region: Helper Methods
    private void logVehicleMakeVO(VehicleMakeVO vehicleMakeVO) {
        log.info("New VehicleMake Name:" + vehicleMakeVO.getNewVehicleMakeName());
        log.info("New VehicleMake Create Date:" + vehicleMakeVO.getNewVehicleMakeCreateDate());
    }

    private void saveVehicleMakeFromVehicleMakeVO(VehicleMakeVO vehicleMakeVO) {
        VehicleMake newVehicleMake = new VehicleMake();

        newVehicleMake.setVehicleMakeName(vehicleMakeVO.getNewVehicleMakeName());
        newVehicleMake.setCreateDate(vehicleMakeVO.getNewVehicleMakeCreateDate());

        vehicleMakeService.saveVehicleMake(newVehicleMake);

    }
    //endregion
}