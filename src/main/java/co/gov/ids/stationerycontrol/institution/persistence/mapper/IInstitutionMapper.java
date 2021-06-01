package co.gov.ids.stationerycontrol.institution.persistence.mapper;

import java.util.List;
import org.mapstruct.*;
import co.gov.ids.stationerycontrol.institution.domain.dto.Institution;
import co.gov.ids.stationerycontrol.institution.persistence.entity.InstitutionEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IInstitutionMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "township", target = "township"),
            @Mapping(source = "attendant", target = "attendant")
    })
    Institution toInstitution(InstitutionEntity entity);

    List<Institution> toInstitutions(List<InstitutionEntity> entities);

    @InheritInverseConfiguration
    InstitutionEntity toEntity(Institution institution);

}
