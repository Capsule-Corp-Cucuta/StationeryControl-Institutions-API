package co.gov.ids.stationerycontrol.institution.web.controller;

import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.gov.ids.stationerycontrol.institution.domain.dto.User;
import co.gov.ids.stationerycontrol.institution.web.feign.IUserFeign;
import co.gov.ids.stationerycontrol.institution.domain.dto.Institution;
import co.gov.ids.stationerycontrol.institution.domain.service.InstitutionService;

@RestController
@Api(tags = "institution")
@RequestMapping("/institution")
public class InstitutionController {

    private final IUserFeign userFeign;
    private final InstitutionService service;

    public InstitutionController(IUserFeign userFeign, InstitutionService service) {
        this.service = service;
        this.userFeign = userFeign;
    }

    @PostMapping
    public ResponseEntity<Institution> create(@RequestBody Institution institution) {
        ResponseEntity<User> userResponse = userFeign.findByIdentification(institution.getAttendant());
        if (userResponse.getStatusCodeValue() == 200) {
            userResponse.getBody().setTownship(institution.getTownship());
            userResponse.getBody().setInstitution(institution.getName());
            userFeign.update(userResponse.getBody());
            return new ResponseEntity<>(service.create(institution), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Institution institution) {
        if (service.delete(institution.getName())) {
            ResponseEntity<User> userResponse = userFeign.findByIdentification(institution.getAttendant());
            if (userResponse.getStatusCodeValue() == 200) {
                userResponse.getBody().setTownship(null);
                userResponse.getBody().setInstitution(null);
                userFeign.update(userResponse.getBody());
            }
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institution>> findAll() {
        return service.findAll()
                .map(institutions -> new ResponseEntity<>(institutions, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Institution>> findByName(@PathVariable("name") String name) {
        return service.findByName(name)
                .map(institutions -> new ResponseEntity<>(institutions, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/township/{township}")
    public ResponseEntity<List<Institution>> findByTownship(@PathVariable("township") String township) {
        return service.findByTownship(township)
                .map(institutions -> new ResponseEntity(institutions, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/attendant/{attendant}")
    public ResponseEntity<List<Institution>> findByAttendant(@PathVariable("attendant") String attendant) {
        return service.findByAttendant(attendant)
                .map(institutions -> new ResponseEntity<>(institutions, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
