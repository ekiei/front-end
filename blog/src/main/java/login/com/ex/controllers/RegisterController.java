package login.com.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.com.ex.models.dao.UsersDao;
import login.com.ex.models.entity.UsersEntity;
import login.com.ex.services.UsersService;

@Controller
public class RegisterController {
	@Autowired
//	private UsersDao usersDao;
	private UsersService usersService;
	
	//登録画面
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register.html";
	}
	
	//登録処理
	@PostMapping("/register/process")
	public String register(@RequestParam String username,
			@RequestParam String email,
			@RequestParam String password
			) {
		
//		用UsersDao的部分
//		if(usersDao.findByUsersName(username) == null) {
//			usersDao.save(new UsersEntity(username,password,email));
//			return "login.html";
//		}else {
//			return "register.html";
//		}
		
//		用UsersService的部分
		if(usersService.CreatUsers(username,password,email)) {
			return "login.html";
		}else {
			return "register.html";
		}
	}
}
