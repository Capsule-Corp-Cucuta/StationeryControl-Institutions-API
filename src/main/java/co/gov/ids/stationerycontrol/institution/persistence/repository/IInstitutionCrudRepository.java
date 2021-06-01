package co.gov.ids.stationerycontrol.institution.persistence.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import co.gov.ids.stationerycontrol.institution.persistence.entity.InstitutionEntity;

public interface IInstitutionCrudRepository extends CrudRepository<InstitutionEntity, String> {

    Optional<List<InstitutionEntity>> findByNameContainingIgnoreCase(String name);

    Optional<List<InstitutionEntity>> findByTownship(String township);

    Optional<List<InstitutionEntity>> findByAttendant(String attendant);

}
