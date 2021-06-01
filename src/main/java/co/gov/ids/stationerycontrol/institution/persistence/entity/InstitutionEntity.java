package co.gov.ids.stationerycontrol.institution.persistence.entity;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "INSTITUTIONS")
public class InstitutionEntity {

    @Id
    private String name;

    @Column(nullable = false)
    private String township;

    @Column(nullable = false)
    private String attendant;

}
