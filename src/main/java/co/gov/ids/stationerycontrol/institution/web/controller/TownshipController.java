package co.gov.ids.stationerycontrol.institution.web.controller;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.ids.stationerycontrol.institution.domain.service.TownshipService;

@RestController
@Api(tags = "township")
@RequestMapping("/township")
public class TownshipController {

    private final TownshipService service;

    public TownshipController(TownshipService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ApiOperation(value = "List all townships", notes = "Service for list all townships")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Townships listed correctly"),
            @ApiResponse(code = 404, message = "Townships not found")
    })
    public ResponseEntity<List<String>> findAll() {
        return service.findAll()
                .map(townships -> new ResponseEntity<>(townships, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "List Townships by name", notes = "Service for list townships by a specific name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Townships listed correctly"),
            @ApiResponse(code = 404, message = "Townships not found")
    })
    public ResponseEntity<List<String>> findByName(@PathVariable("name") String name) {
        return service.findByName(name)
                .map(townships -> new ResponseEntity<>(townships, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
