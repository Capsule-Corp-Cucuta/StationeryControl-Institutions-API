package co.gov.ids.stationerycontrol.institution.domain.dto;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String userType;
    private String department;
    private String township;
    private String institution;

}
