package co.gov.ids.stationerycontrol.institution.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import co.gov.ids.stationerycontrol.institution.domain.repository.ITownshipRepository;

@Repository
public class TownshipRepository implements ITownshipRepository {

    private final ITownshipCrudRepository repository;

    public TownshipRepository(ITownshipCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<String>> findAll() {
        List<String> townships = new ArrayList<>();
        repository.findAll().forEach(entity -> townships.add(entity.getName()));
        return Optional.of(townships);
    }

    @Override
    public Optional<List<String>> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).map(entities -> {
            List<String> townships = new ArrayList<>();
            entities.forEach(entity -> townships.add(entity.getName()));
            return townships;
        });
    }
}
