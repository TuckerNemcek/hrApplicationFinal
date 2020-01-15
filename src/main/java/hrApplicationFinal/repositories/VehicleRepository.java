package hrApplicationFinal.repositories;

import hrApplicationFinal.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}