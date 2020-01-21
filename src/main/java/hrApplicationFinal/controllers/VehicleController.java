package hrApplicationFinal.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hrApplicationFinal.domain.VO.VehicleVO;
import hrApplicationFinal.domain.Vehicle;
import hrApplicationFinal.services.VehicleModelService;
import hrApplicationFinal.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    private Logger log = Logger.getLogger(VehicleController.class);

    @RequestMapping(value = "/Vehicles/List" , method = RequestMethod.GET)
    public String vehicleList(Model model) {
        model.addAttribute("listAllVehicles", vehicleService.listAllVehicles());
        return "vehicles/vehicleList";
    }

    @RequestMapping(value = "/Vehicles/Add", method = RequestMethod.GET)
    public String vehicleAddGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        return "vehicles/vehicleAdd";
    }

    @RequestMapping(value = "/Vehicles/Add", method = RequestMethod.POST)
    public String vehicleAddPost(Model model, VehicleVO vehicleVO){
        Vehicle vehicle = new Vehicle();

        vehicle.setLicensePlate(vehicleVO.getLicensePlate());
        vehicle.setVehicleModel(vehicleVO.getVehicleModel());
        vehicle.setVin(vehicleVO.getVin());
        vehicle.setColor(vehicleVO.getColor());
        vehicle.setYearProduced(vehicleVO.getYearProduced());
        vehicleService.saveVehicle(vehicle);

        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());

        return "redirect:/Vehicles/List";
    }

    @RequestMapping(value = "/Vehicles/Edit/{id}", method = RequestMethod.GET)
    public String vehicleEditGet(@PathVariable int id, Model model, VehicleVO vehicleVO) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        vehicleVO.setColor(vehicle.getColor());
        vehicleVO.setId(vehicle.getId());
        vehicleVO.setLicensePlate(vehicle.getLicensePlate());
        vehicleVO.setVehicleModel(vehicle.getVehicleModel());
        vehicleVO.setYearProduced(vehicle.getYearProduced());
        vehicleVO.setVin(vehicle.getVin());

        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());

        model.addAttribute("vehicleVO", vehicleVO);
        return "vehicles/vehicleEdit";
    }

    @RequestMapping(value = "/Vehicles/Update", method = RequestMethod.POST)
    public String vehicleUpdate(VehicleVO vehicleVO, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleVO.getId());
        vehicle.setVehicleModel(vehicleVO.getVehicleModel());
        vehicle.setColor(vehicleVO.getColor());
        vehicle.setVin(vehicleVO.getVin());
        vehicle.setLicensePlate(vehicleVO.getLicensePlate());
        vehicle.setYearProduced(vehicleVO.getYearProduced());
        vehicleService.saveVehicle(vehicle);

        return "redirect:/Vehicles/List";

    }

    @RequestMapping(value = "/Vehicles/Delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id) {

        Vehicle vehicle = vehicleService.getVehicleById(id);
        vehicleService.deleteVehicle(vehicle.getId());

        return "redirect:/Vehicles/List";
    }

}
