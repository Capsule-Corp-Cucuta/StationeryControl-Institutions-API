package co.gov.ids.stationerycontrol.institution.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import co.gov.ids.stationerycontrol.institution.domain.repository.ITownshipRepository;

@Service
public class TownshipService {

    private final ITownshipRepository repository;

    public TownshipService(ITownshipRepository repository) {
        this.repository = repository;
    }

    public Optional<List<String>> findAll() {
        return repository.findAll();
    }

    public Optional<List<String>> findByName(String name) {
        return repository.findByName(name);
    }
}
