package com.basic.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.app.model.Response;
import com.basic.app.model.Status;
import com.basic.app.repository.CustomRepository;

@Service
public class ApiService {

	@Autowired 
	private CustomRepository customRepos;
	
	public Response<List<Map<String, Object>>> getProvinceList(){
		Response<List<Map<String, Object>>> result = new Response<>();
		Status status = new Status();
		result.setResponse(status);
		try {
			status.setCode("00");
			
			List<Map<String, Object>> xResult = customRepos.callListProvince();
			
			result.setOutput(xResult);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setCode("65");
			status.setMessage(e.getMessage());
		}
		
		return result;
	}
}
