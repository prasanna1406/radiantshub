package com.radiantshub.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.radiantshub.entities.IGenericVO;
import com.radiantshub.entities.User;
import com.radiantshub.exceptions.RadiantsHubException;
import com.radiantshub.service.RadiantsService;

public class RadiantsHandlerImpl implements RadiantsHandler {

	@Autowired
	RadiantsService<IGenericVO> radiantsService;
	
	@Override
	public void saveUser(User user) throws RadiantsHubException {
		
		radiantsService.save(user);
	}
}
