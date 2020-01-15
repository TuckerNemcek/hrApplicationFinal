package hrApplicationFinal.repositories;

import hrApplicationFinal.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {
}
