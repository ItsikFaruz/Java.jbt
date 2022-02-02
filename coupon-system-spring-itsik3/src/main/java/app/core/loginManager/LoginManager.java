package app.core.loginManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.exception.CouponSystemException;
import app.core.loginManager.Clients.ClientType;
import app.core.servicies.AdminService;
import app.core.servicies.ClientService;
import app.core.servicies.CompanyService;
import app.core.servicies.CustomerService;

@Component
public class LoginManager {

	@Autowired
	protected CustomerService customerService;
	@Autowired
	protected CompanyService companyService;
	@Autowired
	protected AdminService adminService;

	public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {

		String type = clientType.toString();
		if (type.equals("CUSTOMER")) {
			if (customerService.login(email, password))
				return customerService;
		} else {
			return null;
		}
		if (type.equals("COMPANY")) {
			if (companyService.login(email, password)) {
				return companyService;
			}
			return null;
		}
		if (type.equals("ADMINISTRATOR")) {
			if (adminService.login(email, password)) {
				return adminService;
			}

			return null;
		}
		return null;

	}

}
