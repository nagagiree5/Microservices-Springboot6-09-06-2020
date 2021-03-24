package io.springboot2.x.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.springboot2.x.dto.LoginNetflixDTO;
import io.springboot2.x.dto.NetflixDevicesDTO;
import io.springboot2.x.dto.NetflixPlanDTO;
import io.springboot2.x.dto.NetflixPlanUpdateDTO;
import io.springboot2.x.dto.NetflixUser2DTO;
import io.springboot2.x.dto.NetflixUserDTO;
import io.springboot2.x.dto.RegisterNetflixDTO;
import io.springboot2.x.service.INetflixUserService;

@RestController
@Validated
@RibbonClient(name = "userribbon")
public class NetflixUserController {
    private static final String PLAN_URL="http://NETFLIX-STREAMING-PLAN/Netflix/getSpecificPlan/{id}";
    private static final String DEVICE_URL="http://NETFLIX-STREAMING-DEVICE/Netflix/devices/{phoneNor}";
    //private static final String DEVICE_RIBBON_URL="http://userribbon/Netflix/devices/{phoneNor}";

    @Autowired
    private INetflixUserService service;
    
    @Autowired
    private UserCircuitBreaker breaker;

   
    
    @Autowired  
    @Qualifier("restTemplate2")
    private RestTemplate restTemplate2;

    @PostMapping("/user/register")
    public boolean registerUser(@RequestBody @Valid RegisterNetflixDTO registerNetflixDTO){
        return service.registerUser(registerNetflixDTO);
    }
    @PostMapping("/user/login")
    public boolean loginUser(@RequestBody @Valid LoginNetflixDTO loginNetflixDTO){
        return service.loginUser(loginNetflixDTO);
    }
 /*   @GetMapping("/user/viewProfile/{phoneNor}")
    public NetflixUserDTO readUser(@PathVariable String phoneNor){
        NetflixUserDTO netflixUserDTO=service.readUser(phoneNor);
        //For call PLAN_URL
        NetflixPlanDTO currentPlan=restTemplate.getForObject(PLAN_URL,NetflixPlanDTO.class,netflixUserDTO.getPlanId());
        netflixUserDTO.setCurrentPlan(currentPlan);
        //For call DEVICE_URL
        ParameterizedTypeReference<List<NetflixDevicesDTO>> typeReference=new ParameterizedTypeReference<List<NetflixDevicesDTO>>() {};
        ResponseEntity<List<NetflixDevicesDTO>> re=restTemplate.exchange(DEVICE_URL, HttpMethod.GET,null,typeReference,phoneNor);
        List<NetflixDevicesDTO> devicesConnected=re.getBody();
        netflixUserDTO.setDevicesConnected(devicesConnected);

        return netflixUserDTO;
    }*/


    @GetMapping(value = "/user/viewProfile/{phoneNor}",produces = {"application/json"})
    public  ResponseEntity<Object> readUser(@PathVariable String phoneNor){
        NetflixUserDTO netflixUserDTO=service.readUser(phoneNor);
        if(netflixUserDTO.getPhoneNor()!=null) {
            //For call PLAN_URL
            NetflixPlanDTO currentPlan = restTemplate2.getForObject(PLAN_URL, NetflixPlanDTO.class, netflixUserDTO.getPlanId());
            netflixUserDTO.setCurrentPlan(currentPlan);
            //For call DEVICE_URL
            ParameterizedTypeReference<List<NetflixDevicesDTO>> typeReference = new ParameterizedTypeReference<List<NetflixDevicesDTO>>() {
            };
			/* For ribbon */
            // ResponseEntity<List<NetflixDevicesDTO>> re = restTemplate2.exchange(DEVICE_RIBBON_URL, HttpMethod.GET, null, typeReference, phoneNor);
            
			/* For Hystrix CircuitBreaker */
            //ResponseEntity<List<NetflixDevicesDTO>> re = restTemplate2.exchange(DEVICE_URL, HttpMethod.GET, null, typeReference, phoneNor);
           //List<NetflixDevicesDTO> devicesConnected = re.getBody();
            
        	/*Here..,Call Hystrix CircuitBreaker */
           List<NetflixDevicesDTO> devicesConnected=breaker.getDevice(phoneNor);
           netflixUserDTO.setDevicesConnected(devicesConnected);
           return new ResponseEntity<Object>(netflixUserDTO ,HttpStatus.OK);

        }
        return new ResponseEntity<Object>("Data is not available!", HttpStatus.OK);
    }
    @PutMapping("/user/update")
    boolean updateUser(@RequestBody @Valid RegisterNetflixDTO registerNetflixDTO){
        return service.updateUser(registerNetflixDTO);
    }
    @PostMapping("/user/v2/update")
    boolean updateUserV2(@RequestBody @Valid NetflixUser2DTO netflixUser2DTO){
        return service.updateUserV2(netflixUser2DTO);
    }
    @DeleteMapping("/user/delete")
    boolean deleteUserByPhoneNor(@RequestParam String phoneNor){
        return service.deleteUserByPhoneNor(phoneNor);
    }
    @PostMapping("/user/update/plan")
    public boolean getUpdatePlanId(@RequestBody @Valid NetflixPlanUpdateDTO netflixPlanUpdateDTO) {
        return service.getUpdatePlanId(netflixPlanUpdateDTO);
    }
    @GetMapping(value = "/user/v2/viewProfile/{phoneNor}",produces = {"application/json"})
    public  ResponseEntity<Object> readUserV2(@PathVariable String phoneNor){
        NetflixUser2DTO netflixUser2DTO=service.readUserV2(phoneNor);
        if(netflixUser2DTO.getPhoneNor()!=null) {
            //For call PLAN_URL
            NetflixPlanDTO currentPlan = restTemplate2.getForObject(PLAN_URL, NetflixPlanDTO.class, netflixUser2DTO.getPlanId());
            netflixUser2DTO.setCurrentPlan(currentPlan);
            //For call DEVICE_URL
            ParameterizedTypeReference<List<NetflixDevicesDTO>> typeReference = new ParameterizedTypeReference<List<NetflixDevicesDTO>>() {
            };
            ResponseEntity<List<NetflixDevicesDTO>> re = restTemplate2.exchange(DEVICE_URL, HttpMethod.GET, null, typeReference, phoneNor);
            List<NetflixDevicesDTO> devicesConnected = re.getBody();
            netflixUser2DTO.setDevicesConnected(devicesConnected);
            return new ResponseEntity<Object>(netflixUser2DTO ,HttpStatus.OK);

        }
        return new ResponseEntity<Object>("Data is not available!", HttpStatus.OK);
    }



}
