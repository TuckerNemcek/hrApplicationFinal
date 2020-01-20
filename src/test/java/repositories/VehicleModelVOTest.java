package repositories;

import hrApplicationFinal.configuration.RepositoryConfiguration;
import hrApplicationFinal.services.VehicleModelService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes ={RepositoryConfiguration.class})
public class VehicleModelVOTest {

    @Autowired
    private VehicleModelService vehicleModelService;


}
