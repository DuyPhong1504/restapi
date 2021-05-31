package project.restapi.controllere;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.AccountDAO;
import model.Account;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
	private static AccountDAO dao = new AccountDAO();
	
	@GetMapping("/getall")
	public List<Account> getAccount() {
		try {
			return dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/regis")
	public boolean regis(@RequestBody Account acc) {
		boolean check=false;
		try {
			check=dao.register(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Account acc) {
		boolean check=false;
		try {
			check= dao.checkLogin(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
