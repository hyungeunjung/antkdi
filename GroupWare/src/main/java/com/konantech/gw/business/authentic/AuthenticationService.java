package com.konantech.gw.business.authentic;

import java.util.HashMap;

public interface AuthenticationService {

	public HashMap<String,String> getAuthentication(String username, String password);

}
