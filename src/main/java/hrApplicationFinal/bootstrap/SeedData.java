package hrApplicationFinal.bootstrap;

import hrApplicationFinal.domain.Vehicle;
import hrApplicationFinal.domain.VehicleMake;
import hrApplicationFinal.domain.VehicleModel;
import hrApplicationFinal.services.VehicleMakeService;
import hrApplicationFinal.services.VehicleModelService;
import hrApplicationFinal.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateVehiclesAndVehicleAttributes();
    }

    private void generateVehiclesAndVehicleAttributes(){
        Date date = new Date();
        Date teslaDate = new Date(2003, Calendar.JULY, 3);

        //region VEHICLE MAKES
        VehicleMake Jeep = new VehicleMake();
        Jeep.setVehicleMakeName("Jeep");
        Jeep.setCreateDate(date);

        VehicleMake Chevy = new VehicleMake();
        Chevy.setVehicleMakeName("Chevy");
        Chevy.setCreateDate(date);

        VehicleMake Tesla = new VehicleMake();
        Tesla.setVehicleMakeName("Tesla");
        Tesla.setCreateDate(teslaDate);
        //endregion

        //region VEHICLE MODELS
        VehicleModel Liberty = new VehicleModel();
        Liberty.setVehicleModelName("Liberty");
        Liberty.setVehicleMake(Jeep);

        VehicleModel Grand_Cherokee = new VehicleModel();
        Grand_Cherokee.setVehicleModelName("Grand_Cherokee");
        Grand_Cherokee.setVehicleMake(Jeep);

        VehicleModel Nova = new VehicleModel();
        Nova.setVehicleModelName("Nova");
        Nova.setVehicleMake(Chevy);

        VehicleModel Model3 = new VehicleModel();
        Model3.setVehicleModelName("Model_3");
        Model3.setVehicleMake(Tesla);
        //endregion

        //region SPECIFIC VEHICLES
        Vehicle momsJeep = new Vehicle();
        momsJeep.setYearProduced(2015);
        momsJeep.setColor("Blue");
        momsJeep.setLicensePlate("998-CQC");
        momsJeep.setVin("17965874123574");
        momsJeep.setVehicleModel(Grand_Cherokee);

        Vehicle myJeep = new Vehicle();
        myJeep.setYearProduced(2011);
        myJeep.setColor("Black");
        myJeep.setLicensePlate("923-ABC");
        myJeep.setVin("41575369875234");
        myJeep.setVehicleModel(Liberty);

        Vehicle theNova = new Vehicle();
        theNova.setYearProduced(1977);
        theNova.setColor("Puke Yellow");
        theNova.setLicensePlate("245-DJN");
        theNova.setVin("87436587419632");
        theNova.setVehicleModel(Nova);

        Vehicle soonMine = new Vehicle();
        soonMine.setYearProduced(2019);
        soonMine.setColor("Silver");
        soonMine.setLicensePlate("JVASCRPT");
        soonMine.setVin("72591463879635");
        soonMine.setVehicleModel(Model3);


        //endregion

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(myJeep);
        vehicleList.add(momsJeep);
        vehicleList.add(theNova);
        vehicleList.add(soonMine);

        vehicleService.saveVehicleList(vehicleList);

    }
}
