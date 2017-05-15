package com.radiantshub.handler;

import com.radiantshub.entities.User;
import com.radiantshub.exceptions.RadiantsHubException;

public interface RadiantsHandler {

	public void saveUser(User user) throws RadiantsHubException;
}
