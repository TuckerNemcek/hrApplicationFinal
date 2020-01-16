package repositories;

import hrApplicationFinal.configuration.RepositoryConfiguration;
import hrApplicationFinal.domain.VehicleMake;
import hrApplicationFinal.repositories.VehicleMakeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class VehicleMakeRepositoryTest {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Test
    public void testSaveVehicleMake() {
        //setup vehicleMake
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeName("Jeep");

        //save vehicleMake, verify it has an ID after the save.
        assertNull(vehicleMake.getId());
        vehicleMakeRepository.save(vehicleMake);
        assertNotNull(vehicleMake.getId());

        //fetch
        VehicleMake fetchedVeMake = vehicleMakeRepository.findOne(vehicleMake.getId());
        assertNotNull(fetchedVeMake);
        assertEquals(vehicleMake.getId(), fetchedVeMake.getId());

        //update
        fetchedVeMake.setVehicleMakeName("Honda");
        vehicleMakeRepository.save(fetchedVeMake);

        VehicleMake updatedVehicleMake = vehicleMakeRepository.findOne(fetchedVeMake.getId());
        assertEquals(updatedVehicleMake.getVehicleMakeName(), "Honda");
    }

}
