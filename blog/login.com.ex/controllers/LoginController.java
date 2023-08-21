package login.com.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import login.com.ex.models.entity.UsersEntity;
import login.com.ex.services.UsersService;

@Controller
public class LoginController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private HttpSession session;
	
	//login画面表示
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}
	
	//ログイン処理
	@PostMapping("/login/process")
	public String login(@RequestParam String username,
			@RequestParam String password,
			Model model) {
		
		UsersEntity user = usersService.loginCheck(username, password);
		if(user != null) {
			//セッションに情報をセットする
			session.setAttribute("users", user);
			model.addAttribute("username",username);
			model.addAttribute("password",password);
			return "front.html";
		}else {
			return "login.html";
		}
	}
	
	//ログアウト
	@GetMapping("/logout")
	public String getLogoutPage() {
		return "login.html";
	}
}
