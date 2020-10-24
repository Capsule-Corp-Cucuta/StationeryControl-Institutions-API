package co.gov.ids.stationerycontrol.institution.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import co.gov.ids.stationerycontrol.institution.domain.dto.Institution;
import co.gov.ids.stationerycontrol.institution.domain.repository.IInstitutionRepository;

@Service
public class InstitutionService {

    private final IInstitutionRepository repository;

    public InstitutionService(IInstitutionRepository repository) {
        this.repository = repository;
    }

    public Institution create(Institution institution) {
        return repository.create(institution);
    }

    public boolean delete(String name) {
        return repository.delete(name);
    }

    public Optional<List<Institution>> findAll() {
        return repository.findAll();
    }

    public Optional<List<Institution>> findByName(String name) {
        return repository.findByName(name);
    }

    public Optional<List<Institution>> findByTownship(String township) {
        return repository.findByTownship(township);
    }

    public Optional<List<Institution>> findByAttendant(String attendant) {
        return repository.findByAttendant(attendant);
    }

}
