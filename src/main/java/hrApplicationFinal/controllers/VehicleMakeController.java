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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String vehicleMakeEditGet(@PathVariable int id, Model model, VehicleMakeVO vehicleMakeVO) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
        vehicleMakeVO.setNewVehicleMakeName(vehicleMake.getVehicleMakeName());
        vehicleMakeVO.setNewVehicleMakeCreateDate(vehicleMake.getCreateDate());
        vehicleMakeVO.setId(vehicleMake.getId());

        model.addAttribute("vehicleMakeVO", vehicleMakeVO);
        return "vehicleMakes/vehicleMakeEdit";
    }

    @RequestMapping(value = "/VehicleMakes/Update", method = RequestMethod.POST)
    public String vehicleMakeUpdate(VehicleMakeVO vehicleMakeVO, Model model) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(vehicleMakeVO.getId());
        vehicleMake.setVehicleMakeName(vehicleMakeVO.getNewVehicleMakeName());
        vehicleMake.setCreateDate(vehicleMakeVO.getNewVehicleMakeCreateDate());
        vehicleMakeService.saveVehicleMake(vehicleMake);

//        System.out.println(vehicleMakeVO.getNewVehicleMakeName());
//        System.out.println(vehicleMakeVO.getId());

        return "vehicleMakes/vehicleMakeEdit";
    }
        //todo: What I suspect is going on here is I am getting an exception because
        // it will delete all children of this element. I need to make my interfaces for Vehicle Model and delete all of them before deleting the make
    @RequestMapping(value = "/VehicleMakes/Delete/{id}", method = RequestMethod.GET)
    public String vehicleMakeDelete(@PathVariable int id, Model model) {

        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
        vehicleMakeService.deleteVehicleMake(vehicleMake.getId());

        model.addAttribute("listAllVehicleMakes", vehicleMakeService.listAllVehicleMakes());

        return "vehicleMakes/vehicleMakeList";
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