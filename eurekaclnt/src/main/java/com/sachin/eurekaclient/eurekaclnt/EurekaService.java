package com.sachin.eurekaclient.eurekaclnt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/passport")
public class EurekaService {
    
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{name}")	
	public List<String> getPassportNo(@PathVariable String name) {
	    
		ResponseEntity<List<String>> ppNos = null;
		try {
// without eureka registration
			//		ppNos =   restTemplate.exchange("http://localhost:8080/rest/db/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
			// with eureka registartion
			ppNos =   restTemplate.exchange("http://db-service/rest/db/" + name, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});			
			
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
		return ppNos.getBody();
	}
	
	
}
