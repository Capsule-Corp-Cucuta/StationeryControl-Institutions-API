package co.gov.ids.stationerycontrol.institution.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import co.gov.ids.stationerycontrol.institution.persistence.entity.TownshipEntity;

public interface ITownshipCrudRepository extends CrudRepository<TownshipEntity, String> {

    Optional<List<TownshipEntity>> findByNameContainingIgnoreCase(String name);

}
