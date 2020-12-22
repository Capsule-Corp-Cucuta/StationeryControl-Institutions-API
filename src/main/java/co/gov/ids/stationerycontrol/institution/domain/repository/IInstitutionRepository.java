package co.gov.ids.stationerycontrol.institution.domain.repository;

import java.util.List;
import java.util.Optional;
import co.gov.ids.stationerycontrol.institution.domain.dto.Institution;

public interface IInstitutionRepository {

    Institution create(Institution institution);

    boolean delete(String name);

    Optional<List<Institution>> findAll();

    Optional<List<Institution>> findByName(String name);

    Optional<List<Institution>> findByTownship(String township);

    Optional<List<Institution>> findByAttendant(String attendant);

    long countInstitutions();
}
