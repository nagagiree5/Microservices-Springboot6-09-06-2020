package com.pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.pack.model.LoginNetflixDTO;
import com.pack.model.NetflixPlanDTO;
import com.pack.model.NetflixTenureDTO;
import com.pack.model.NetflixUserDTO;
import com.pack.model.RegisterNetflixDTO;



@Controller
public class NetflixUIController {

	private static final String ALLPLANS_URL="http://localhost:3333/Netflix/getAllPlans";
	private static final String REGISTER_URL="http://localhost:2222/Netflix/user/register";
	private static final String LOGIN_URL="http://localhost:2222/Netflix/user/login";
	private static final String PROFILE_URL="http://localhost:2222/Netflix/user/viewProfile/{phoneNor}";

	private static final String TENURE_URL="http://localhost:5555/Netflix/tenure/{phoneNor}";
	private static final String PROFILE2_URL="http://localhost:2222/Netflix/user/v2/viewProfile/{phoneNor}";
	private static final String PROFILEUPDATE_URL="http://localhost:2222/Netflix/user/v2/update";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping({"/index","/"})
	public String getIndexPage() {
		return "index";	
	}
	private List<NetflixPlanDTO> getAllPlans(){
		 ParameterizedTypeReference<List<NetflixPlanDTO>> typeRef = new ParameterizedTypeReference<List<NetflixPlanDTO>>() {};

		 ResponseEntity<List<NetflixPlanDTO>> re = restTemplate.exchange(ALLPLANS_URL, HttpMethod.GET, null, typeRef);
         List<NetflixPlanDTO> plansList = re.getBody();
         return plansList;
	}
	@GetMapping("/registerPage")
	public String getRegisterPage(Model model) {
		//For call netflix plan microservice
		
		RegisterNetflixDTO registerNetflixDTO=new RegisterNetflixDTO();
		registerNetflixDTO.setPlansList(getAllPlans());
		model.addAttribute("registerNetflixDTO",registerNetflixDTO);
		return "register";
		
	}
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute @Valid RegisterNetflixDTO registerNetflixDTO, BindingResult result,Model model) {
		if(result.hasErrors()) {
			//For call netflix plan microservice
			
			registerNetflixDTO.setPlansList(getAllPlans());
			model.addAttribute("registerNetflixDTO",registerNetflixDTO);
			return "register";	
		}

          //For call netflix-user microservice
		boolean flag=restTemplate.postForObject(REGISTER_URL,registerNetflixDTO, Boolean.class);
		if(flag==true) {
			String message="Netflix registration is successful...";
			model.addAttribute("message",message);
			return "index";
		}else {
			String message="Alredy user is registered with this phone number..,Try again";
			
			
			registerNetflixDTO.setPlansList(getAllPlans());
			model.addAttribute("registerNetflixDTO",registerNetflixDTO);
			model.addAttribute("message",message);
			return "register";
		}
	}
	

	@GetMapping("/loginPage")
	public String getLoginPage() {
		return "login";	
	}
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String phoneNor,@RequestParam String password,Model model,HttpServletRequest request) {
		LoginNetflixDTO login=new LoginNetflixDTO();
		login.setPhoneNor(phoneNor);
		login.setPassword(password);
		
		//For call netflix user microservice
		boolean flag=restTemplate.postForObject(LOGIN_URL,login,Boolean.class);
		if(flag==true) {
			HttpSession session=request.getSession();
			session.setAttribute("phoneNor",phoneNor);
			return "HOME";
		}
		else {
			model.addAttribute("message","Bad Credentials...");
			return "login";
		}
	}
	
	@GetMapping("/profile")
	public String getUserProfile(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String phoneNor=(String) session.getAttribute("phoneNor");
		NetflixUserDTO netflixUserDTO=restTemplate.getForObject(PROFILE_URL,NetflixUserDTO.class,phoneNor);
		model.addAttribute("user",netflixUserDTO);
		return "profile";
		
	}
	
	@GetMapping("/getAllPlans")
	private String getAllPlans2(Model model){
		 ParameterizedTypeReference<List<NetflixPlanDTO>> typeRef = new ParameterizedTypeReference<List<NetflixPlanDTO>>() {};

		 ResponseEntity<List<NetflixPlanDTO>> re = restTemplate.exchange(ALLPLANS_URL, HttpMethod.GET, null, typeRef);
        List<NetflixPlanDTO> plansList = re.getBody();
        model.addAttribute("plans",plansList);
        return "getAllPlans";
	}

	  @GetMapping("/getTenure")
		public String getTenure(Model model,HttpServletRequest request){
			HttpSession session=request.getSession();
			String phoneNor=(String) session.getAttribute("phoneNor");
			System.out.println("--->Test2PhoneNor--->"+phoneNor);
			 ParameterizedTypeReference<List<NetflixTenureDTO>> typeRef = new ParameterizedTypeReference<List<NetflixTenureDTO>>() {};

			 ResponseEntity<List<NetflixTenureDTO>> re = restTemplate.exchange(TENURE_URL, HttpMethod.GET, null, typeRef,phoneNor);
	         List<NetflixTenureDTO> netflixTenureDTOList = re.getBody();
	        model.addAttribute("tenure",netflixTenureDTOList);
			System.out.println("--->Test1--->"+netflixTenureDTOList);
			return "getTenure";

		}
	

		@GetMapping("/profileEdit")
		public String getUserProfile2(Model model,HttpServletRequest request) {
			HttpSession session=request.getSession();
			String phoneNor=(String) session.getAttribute("phoneNor");
			NetflixUserDTO netflixUserDTO=restTemplate.getForObject(PROFILE2_URL,NetflixUserDTO.class,phoneNor);
			netflixUserDTO.setPlansList(getAllPlans());
			System.out.println("---Test3--->"+netflixUserDTO);
			model.addAttribute("user",netflixUserDTO);
			return "profileEdit";
			
		}
		
		@PostMapping("/updateUser")
		public String updateUserV2(@ModelAttribute @Valid NetflixUserDTO netflixUserDTO, BindingResult result,Model model) {
			if(result.hasErrors()) {
			
				  
				netflixUserDTO.setPlansList(getAllPlans());
				model.addAttribute("user",netflixUserDTO);
				return "profileEdit";	
			}

	        
			boolean flag=restTemplate.postForObject(PROFILEUPDATE_URL,netflixUserDTO, Boolean.class);
			if(flag==true) {
				String message="Netflix profile is updated...";
				model.addAttribute("message",message);
				return "HOME";
			}else {
				String message="Not updated something went wrong!..,Try again";
				
				
				netflixUserDTO.setPlansList(getAllPlans());
				model.addAttribute("user",netflixUserDTO);
				model.addAttribute("message",message);
				return "profileEdit";
			}
		}
}
 