package co.gov.ids.stationerycontrol.institution.web.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import co.gov.ids.stationerycontrol.institution.domain.dto.User;

@FeignClient(name = "STATIONERYCONTROL-USER-API")
public interface IUserFeign {

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> findByIdentification(@PathVariable("id") String identification);

    @PutMapping("/api/user/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody User user);

}
