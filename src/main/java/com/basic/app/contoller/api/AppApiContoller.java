package com.basic.app.contoller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.app.model.Response;
import com.basic.app.model.Status;
import com.basic.app.model.User;
import com.basic.app.service.ApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Web Service", value="v2")
@RestController
@RequestMapping("/api")
public class AppApiContoller {

	
	@Autowired
	private ApiService apiService;
	
	
	
	@ApiOperation(value="WS101 findOneUserById", notes="WS101 findOneUserById")
	@RequestMapping(method=RequestMethod.GET, value="/findOneUserById")
	public Response<User> findOneUserById(@RequestParam(value="userId") String userId){
		Response<User> result = new Response<User>();
		
		//success
		Status status = new Status();
		status.setCode("00");
		status.setMessage("Find User Complete");
		
		result.setResponse(status);
		
		User user = new User();
		user.setName("Jane Doe");
		user.setPhone("888-555-1212");
		user.setRelationship("spouse");
		
		result.setOutput(user);
		
		return result;
	}
	
	@ApiOperation(value="WS101 get Province List", notes="get Province List")
	@RequestMapping(method=RequestMethod.GET, value="/getProvinceList")
	public Response<List<Map<String, Object>>> getProvinceList(){
		Response<List<Map<String, Object>>> result = new Response<List<Map<String, Object>>>();
		
		//success
		result = apiService.getProvinceList();
		
		return result;
	}
}
