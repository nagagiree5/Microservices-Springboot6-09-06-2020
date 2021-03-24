package io.springboot2.x.controller;

import io.springboot2.x.domain.NetflixDevice;
import io.springboot2.x.dto.NetflixDeviceDTO;
import io.springboot2.x.dto.NetflixDevicesDTO;
import io.springboot2.x.service.INetflixDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class NetflixDeviceController {

    @Autowired
    private INetflixDeviceService service;

    @PostMapping("/device/add")
    public ResponseEntity<String> isDeviceExistOrNot(@RequestBody @Valid NetflixDeviceDTO netflixDeviceDTO){
        boolean flag =service.isDeviceExistOrNot(netflixDeviceDTO);
        if (flag==true){
            return ResponseEntity.ok("Device data is added to database");
        }
        return ResponseEntity.ok("Device data is alredy exist");
    }
    @GetMapping("/devices/{phoneNor}")
    public ResponseEntity<List<NetflixDevicesDTO>> findByMobile(@PathVariable String phoneNor){
    	 System.out.println("--->Test this is instance: 9493"); 
        List<NetflixDevicesDTO> netflixTenureDTO=service.findByMobile(phoneNor);

        return new ResponseEntity<List<NetflixDevicesDTO>>(netflixTenureDTO, HttpStatus.OK);
    }
    @DeleteMapping("/device/delete/{phoneNor}")
    public ResponseEntity<String> deleteByMobile(@PathVariable("phoneNor") String phoneNor){
        boolean flag =service.deleteByMobile(phoneNor);
       
        if (flag==true){
            return ResponseEntity.ok("With this phone number devices data is deleted");
        }
        return ResponseEntity.ok("With this phone number devices data is doesn't exist");
    }

    @GetMapping("/device/v1/getAll")
    public ResponseEntity<List<NetflixDevice>> getAllNetflixDeviceDetailsV1(){
        List<NetflixDevice> netflixDevice=service.getAllNetflixDeviceDetailsV1();

        return new ResponseEntity<List<NetflixDevice>>(netflixDevice, HttpStatus.OK);
    }
    @GetMapping("/device/v2/getAll")
    public ResponseEntity<List<NetflixDeviceDTO>> getAllNetflixDeviceDetailsV2(){
        List<NetflixDeviceDTO> netflixDeviceDTO=service.getAllNetflixDeviceDetailsV2();

        return new ResponseEntity<List<NetflixDeviceDTO>>(netflixDeviceDTO, HttpStatus.OK);
    }
    @DeleteMapping("/device/delete")
    public ResponseEntity<String>  deleteNetflixDeviceById(@RequestParam Integer id){
        boolean flag =service.deleteNetflixDeviceById(id);
        if (flag==true){
            return ResponseEntity.ok("Devices data is delete from database");
        }
        return ResponseEntity.ok("Devices data or Id is doesn't exist");
    }
}
