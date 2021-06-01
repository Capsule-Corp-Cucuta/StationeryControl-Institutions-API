package co.gov.ids.stationerycontrol.institution.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import co.gov.ids.stationerycontrol.institution.domain.dto.Institution;
import co.gov.ids.stationerycontrol.institution.domain.repository.IInstitutionRepository;
import co.gov.ids.stationerycontrol.institution.persistence.mapper.IInstitutionMapper;

@Repository
public class InstitutionRepository implements IInstitutionRepository {

    private final IInstitutionMapper mapper;
    private final IInstitutionCrudRepository repository;

    public InstitutionRepository(IInstitutionMapper mapper, IInstitutionCrudRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Institution create(Institution institution) {
        return mapper.toInstitution(repository.save(mapper.toEntity(institution)));
    }

    @Override
    public boolean delete(String name) {
        return repository.findById(name).map(entity -> {
            repository.deleteById(name);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<List<Institution>> findAll() {
        List<Institution> institutions = new ArrayList<>();
        repository.findAll().forEach(entity -> {
            institutions.add(mapper.toInstitution(entity));
        });
        return Optional.of(institutions);
    }

    @Override
    public Optional<List<Institution>> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).map(entities -> mapper.toInstitutions(entities));
    }

    @Override
    public Optional<List<Institution>> findByTownship(String township) {
        return repository.findByTownship(township).map(entities -> mapper.toInstitutions(entities));
    }

    @Override
    public Optional<List<Institution>> findByAttendant(String attendant) {
        return repository.findByAttendant(attendant).map(entities -> mapper.toInstitutions(entities));
    }

    @Override
    public long countInstitutions() {
        return repository.count();
    }
}
