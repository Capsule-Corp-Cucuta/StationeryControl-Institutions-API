package co.gov.ids.stationerycontrol.institution.persistence.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "TOWNSHIPS")
public class TownshipEntity {

    @Id
    private String name;

}
