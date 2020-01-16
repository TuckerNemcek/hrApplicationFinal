package hrApplicationFinal.controllers;

import hrApplicationFinal.domain.VO.VehicleMakeVO;
import hrApplicationFinal.domain.VO.VehicleMakeVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleMakeController {

    private Logger log = Logger.getLogger(VehicleMakeController.class);

    @RequestMapping(value = "/VehicleMakes", method = RequestMethod.GET)
    public String vehicleModelMain(Model model)    {
        model.addAttribute("vehicleMakeVO", new VehicleMakeVO());
        return "vehicleMakes/VehicleMakeMain";
    }


    @RequestMapping(value = "/VehicleMakes", method = RequestMethod.POST)
    public String vehicleMakePost(VehicleMakeVO vehicleMakeVO, Model model){
        logVehicleMakeVO(vehicleMakeVO);
        return "vehicleMakes/VehicleMakeMain";
    }


//    region: Helper Methods
    private void logVehicleMakeVO(VehicleMakeVO vehicleMakeVO) {
        log.info("New VehicleMake Name:" + vehicleMakeVO.getNewVehicleMakeName());
        log.info("New VehicleMake Create Date:" + vehicleMakeVO.getNewVehicleMakeCreateDate());
    }
    //endregion
}