package hrApplicationFinal.controllers;

import hrApplicationFinal.domain.VO.VehicleMakeVO;
import hrApplicationFinal.domain.VO.VehicleMakeVO;
import hrApplicationFinal.domain.Vehicle;
import hrApplicationFinal.domain.VehicleMake;
import hrApplicationFinal.domain.VehicleModel;
import hrApplicationFinal.services.VehicleMakeService;
import hrApplicationFinal.services.VehicleModelService;
import hrApplicationFinal.services.VehicleService;
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

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

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

    @RequestMapping(value = "/VehicleMakes/Delete/{id}", method = RequestMethod.GET)
    public String vehicleMakeDelete(@PathVariable int id) {

        Iterable<Vehicle> vehicleList = vehicleService.listAllVehicles();
        Iterable<VehicleModel> vehicleModelList = vehicleModelService.listAllVehicleModels();

        VehicleMake delVehicleMake = vehicleMakeService.getVehicleMakeById(id);

        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getVehicleModel().getVehicleMake().getId().equals(delVehicleMake.getId())){
                vehicleService.deleteVehicle(vehicle.getId());
            }
        }
        for(VehicleModel vehicleModel : vehicleModelList) {
            if(vehicleModel.getVehicleMake().getId().equals(delVehicleMake.getId())){
                vehicleModelService.deleteVehicleModel(vehicleModel.getId());
            }
        }
        vehicleMakeService.deleteVehicleMake(delVehicleMake.getId());


        return "redirect:/VehicleMakes/List";
    }

//    region: Helper Methods
    private void logVehicleMakeVO(VehicleMakeVO vehicleMakeVO) {
        log.info("New VehicleMake Name:" + vehicleMakeVO.getNewVehicleMakeName());
        log.info("New VehicleMake Create Date:" + vehicleMakeVO.getNewVehicleMakeCreateDate());
    }

    private String saveVehicleMakeFromVehicleMakeVO(VehicleMakeVO vehicleMakeVO) {
        VehicleMake newVehicleMake = new VehicleMake();

        newVehicleMake.setVehicleMakeName(vehicleMakeVO.getNewVehicleMakeName());
        newVehicleMake.setCreateDate(vehicleMakeVO.getNewVehicleMakeCreateDate());

        vehicleMakeService.saveVehicleMake(newVehicleMake);

        return "redirect:/VehicleMakes/List";
    }
    //endregion
}