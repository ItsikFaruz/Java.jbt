package app.core.loginManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import app.core.exception.CouponSystemException;
import app.core.loginManager.Clients.ClientType;
import app.core.servicies.ClientService;

@Component
public class LoginManager {

	@Autowired
	private ApplicationContext ctx;
	
	public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
		ClientService clientService;
		
		String type = clientType.toString();
		if (type.equals("CUSTOMER")) {
			clientService = ctx.getBean("customerService" , ClientService.class);
			if (clientService.login(email, password)) {
				return clientService;
			}		
	
		}
		 
		if (type.equals("COMPANY")) {
			 clientService = ctx.getBean("companyService" , ClientService.class);
			if (clientService.login(email, password)) {
				return clientService;
			}		
		
		}
	
		if (type.equals("ADMINISTRATOR")) {
			 clientService = ctx.getBean("adminService" , ClientService.class);
			if (clientService.login(email, password)) {
				return clientService;
			}		
		
		}	
	
	return null;
	}
}
