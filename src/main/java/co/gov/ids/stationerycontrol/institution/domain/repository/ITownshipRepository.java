package co.gov.ids.stationerycontrol.institution.domain.repository;

import java.util.List;
import java.util.Optional;

public interface ITownshipRepository {

    Optional<List<String>> findAll();

    Optional<List<String>> findByName(String name);

}
