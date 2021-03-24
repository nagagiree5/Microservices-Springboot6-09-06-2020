package io.springboot2.x.controller;

import io.springboot2.x.dto.NetflixTenure2DTO;
import io.springboot2.x.dto.NetflixTenureDTO;
import io.springboot2.x.service.INetflixTenureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class NetflixTenureController {
    @Autowired
    private INetflixTenureService service;
    @GetMapping("/tenure/{phoneNor}")
    public ResponseEntity<List<NetflixTenure2DTO>> getByMobileNor(@PathVariable("phoneNor") String phoneNor){
        List<NetflixTenure2DTO> netflixTenure2DTO=service.getByMobileNor(phoneNor);

        return new ResponseEntity<List<NetflixTenure2DTO>>(netflixTenure2DTO, HttpStatus.OK);

    }
    @GetMapping("/tenures")
    public ResponseEntity<List<NetflixTenure2DTO>> getAllNetflixTenureDetails(){
        List<NetflixTenure2DTO> netflixTenure2DTO=service.getAllNetflixTenureDetails();

        return new ResponseEntity<List<NetflixTenure2DTO>>(netflixTenure2DTO, HttpStatus.OK);
    }
    @DeleteMapping("/tenure/delete")
    public ResponseEntity<String> deleteNetflixTenureById(@RequestParam("id") Integer id) {
        boolean flag=service.deleteNetflixTenureById(id);
        if(flag==true) {
            return ResponseEntity.ok("User data is deleted from database...");

        }
        return ResponseEntity.ok("Id is doesn't exist!...");
    }

    @PostMapping(value = "/tenure/add")
    public ResponseEntity<String> addNetflixTenure(@RequestBody @Valid NetflixTenureDTO netflixTenureDTO){
        boolean flag=service.addNetflixTenure(netflixTenureDTO);
        if(flag==true) {
            return ResponseEntity.ok("User data is added to database...");

        }
        return ResponseEntity.ok("Id is alredy exist!...");
    }

    @PutMapping(value = "/tenure/update", consumes = { "application/json" })
    public ResponseEntity<String> updateNetflixTenure(@RequestBody @Valid NetflixTenureDTO netflixTenureDTO){
        boolean flag=service.updateNetflixTenure(netflixTenureDTO);
        if(flag==true) {
            return ResponseEntity.ok("User data is updated in database...");

        }
        return ResponseEntity.ok("Id is doesn't exist!...");
    }

}
