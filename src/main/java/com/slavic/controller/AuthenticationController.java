package com.slavic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.slavic.dto.Response;
import com.slavic.dto.req.Login;
import com.slavic.service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AuthService authService;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/Plans_list")
	public String method3() {
		LOG.info("Inside method3");
		String baseUrl = "http://localhost:8083/microservice4";
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {

		}
		String response=(String) restTemplate.exchange(baseUrl,
				HttpMethod.GET, null,String.class).getBody();
		LOG.info("The response recieved by method3 is "+ response);
		return response;
	}
	
	@PostMapping("/getAuthToken")
	public @ResponseBody Response<?> login(@RequestBody Login login){		
		return authService.getAuthToken(login);
	}
	
	
	
	
}
