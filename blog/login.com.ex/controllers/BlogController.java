package login.com.ex.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import login.com.ex.models.entity.BlogEntity;
import login.com.ex.models.entity.UsersEntity;
import login.com.ex.services.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService; 
	@Autowired
	private HttpSession session;
	
	@GetMapping("/front")
	public String getFrontPage() {
		return "front.html";
	}
	
	//一覧画面
	@GetMapping("/list")
	public String getKijiPage(Model model) {
		UsersEntity users = (UsersEntity)session.getAttribute("users");
		if(users == null) {
			return "redirect:/front";
		}else {
			List<BlogEntity>blogList = blogService.selectAll(users.getUsersId());
			model.addAttribute("blogList", blogList);
			model.addAttribute("usersName", users.getUsersName());
			return "list.html";
		}
	}
	
	//blog画面
	@GetMapping("/blog/register")
	public String getBlogRegisterPage(Model model) {
		UsersEntity users = (UsersEntity)session.getAttribute("users");
		if(users == null) {
			return "blog_register.html";
		}else {
			model.addAttribute("usersName", users.getUsersName());
			return "blog_register.html";
		}
	}
	//blog登録処理
	@PostMapping("/blog/register/process")
	public String getBlogRegisterProcess(@RequestParam String blogTitle,
			@RequestParam MultipartFile blogImage,
			@RequestParam String article,Model model) {
		UsersEntity users = (UsersEntity)session.getAttribute("users");
		Long usersId = users.getUsersId();
		if(users == null) {
			return "redirect:/login";
		}else {
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date()) + blogImage.getOriginalFilename();
			try {
				Files.copy(blogImage.getInputStream(), Path.of(""+ fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(blogService.createBlog(blogTitle, fileName, article, article)) {
				return "redirect:/list";
			}else {
				return "redirect:/blog/register";
			}
		}
	}
	
	//blog更新
	@GetMapping("/blog/edit/{blogId}")
	public String getBlogEditPage(@PathVariable long blogId, Model model) {
		
		return "blog_edit.html";
	}
	
	//更新処理
//	@PostMapping("/blog/edit/process")
//	public String getBlogEditProcess(@RequestParam Long blogId,
//			@RequestParam String blogTitle,@RequestParam MultipartFile blogImage,
//			@RequestParam String article,@RequestParam String usersId,
//			@RequestParam String productDescription,Model model) {
//		UsersEntity users = (UsersEntity)session.getAttribute("users");
//	}
	
	//削除処理
	@PostMapping("/blog/delete")
	public String delete(@RequestParam Long blogId){
		if(blogService.deleteBlog(blogId)){
			return "redirect:/list";
		}else {
			return "";
		}
	}
	
	@GetMapping("/profile")
	public String getProfilePage(Model model) {
		return "profile.html";
	}
	
	@GetMapping("/naruto")
	public String getNarutoPage(Model model) {
		return "naruto.html";
	}

}
