package app.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.exception.CouponSystemException;
import app.core.jwt.util.JwtUtil;
import app.core.jwt.util.JwtUtil.AdminDetails;
import app.core.jwt.util.JwtUtil.ClientDetails;
import app.core.loginManager.Clients.AdmintType;
import app.core.loginManager.Clients.ClientType;
import app.core.loginManager.LoginManager;

@RestController
public class LoginController {
	
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private JwtUtil jwtUtil;

	@PutMapping("/client_login")
	public String login(@RequestParam String email ,@RequestParam String password, @RequestParam ClientType clientType ,@RequestParam int clientId  ) throws CouponSystemException {
		try {
			if(this.loginManager.login(email, password, clientType , clientId) != null) {
								
				ClientDetails client = new ClientDetails(email,clientType,password,clientId );
				return jwtUtil.generateToken(client);
			}else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED , "bad request");
			}
		}catch (CouponSystemException e) {
			 throw new CouponSystemException(e.getMessage());
		}
	
	}


	
	@PutMapping("/admin_login")
	public String admin_login(@RequestParam String email ,@RequestParam String password) throws CouponSystemException {
		try {
			if(this.loginManager.adminLogin(email, password) !=null ) {
				
				AdminDetails admin = new AdminDetails(email,password, AdmintType.ADMINISTRATOR );
				return jwtUtil.generateAdminToken(admin);
			}else {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED , "bad request");
			}
		}catch (CouponSystemException e) {
			throw new CouponSystemException(e.getMessage());
		}
		
	}
}		
	
	

