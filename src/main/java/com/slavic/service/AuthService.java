package com.slavic.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.slavic.dto.ErrorMsg;
import com.slavic.dto.Response;
import com.slavic.dto.req.Login;



@Service
public class AuthService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate restTemplate;


	public ErrorMsg error(Integer code,String message) {
		ErrorMsg error = new ErrorMsg();
		error.setErrorCode(0);
		error.setMessage(message);
		return error;
	}
	
	
	public Response<?> getAuthToken(Login login){
		
		Response<?> res = new Response<String>();
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("username", login.getUsername());
		HttpEntity<HashMap<String, String>> request = new HttpEntity<HashMap<String, String>>(map);
		String response = null;
		try {
			String baseUrl = "http://localhost:8084/user/user-details";
			response = (String) restTemplate.exchange(baseUrl, HttpMethod.POST, request, String.class).getBody();
			//String status = getthierdparty();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		if("success".equals(response)) {
			LOG.info("get token successfully !!! !");
			res.setMessage("success");
		}else {
			LOG.info("get token failed !!! !");
			res.setMessage("failed");
		}
		return res;
		
	}
	
	


}
