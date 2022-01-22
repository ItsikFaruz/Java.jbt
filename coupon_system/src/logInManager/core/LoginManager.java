package logInManager.core;

import coupon.core.exception.CouponSystemException;
import coupon.core.facades.AdminFacade;
import coupon.core.facades.ClientFacade;
import coupon.core.facades.CompanyFacade;
import coupon.core.facades.CustomerFacade;
import logInManager.core.clients.ClientType;

public class LoginManager {

	private LoginManager() {

	}

	private static LoginManager instance = new LoginManager();

	public static LoginManager getInstance() {
		return instance;
	}

	public ClientFacade logIn(String email, String password, ClientType clientType) throws CouponSystemException {
		String type = clientType.toString();
		if (type.equals("ADMINISTRATOR")) {
			ClientFacade clientFacade = new AdminFacade();
			if (clientFacade.login(email, password)) {
				return clientFacade;
			}
			return null;
		}
		if (type.equals("COMPANY")) {
			ClientFacade clientFacade = new CompanyFacade();
			if (clientFacade.login(email, password)) {
				return clientFacade;
			}
			return null;
		}
		if (type.equals("CUSTOMER")) {
			ClientFacade clientFacade = new CustomerFacade();
			if (clientFacade.login(email, password)) {
				return clientFacade;
			}
			return null;
		}
		return null;

	}
}
