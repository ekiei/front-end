package login.com.ex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import jakarta.servlet.http.HttpSession;
import login.com.ex.models.entity.UsersEntity;
import login.com.ex.services.UsersService;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UsersService usersService;
	
	@BeforeEach
	private void prepareData() {
		UsersEntity usersEntity = new UsersEntity("zhang","zhang","zhang@gmail.com");
		when(usersService.loginCheck(eq("zhang"),eq( "zhang"))).thenReturn(usersEntity);
//		when(usersService.loginCheck(eq("zhang"),eq( "zhan"))).thenReturn(null);
	}
	
	//login画面表示成功テスト
	@Test
	public void testGetLoginPage_Succeed()throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/login");
		mockMvc.perform(request)
		.andExpect(view().name("login.html"));
	}
	
	//login登録できるテスト
	@Test
	public void testLogin_Succeed()throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.post("/login/process")
				.param("username", "zhang")
				.param("password", "zhang");
		MvcResult result = mockMvc.perform(request)
				.andExpect(redirectedUrl("/front")).andReturn();
		
		//セッション取得
		HttpSession session = result.getRequest().getSession();
		
		//session設定
		UsersEntity user = (UsersEntity)session.getAttribute("users");
		assertNotNull(user);
		assertEquals("zhang",user.getUsersName());
		assertEquals("zhang",user.getPassword());
		assertEquals("zhang@gmail.com",user.getEmail());
	}
	
	//loginするときユーザー名が間違っていたテスト
	@Test
	public void testLogin_WrongUsername_Unsuccessful()throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.post("/login/process")
				.param("username", "hina")
				.param("password", "zhang");
		MvcResult result = mockMvc.perform(request)
				.andExpect(redirectedUrl("/login")).andReturn();
		
		//セッション取得
		HttpSession session = result.getRequest().getSession();
		
		//session設定
		UsersEntity user = (UsersEntity)session.getAttribute("users");
		assertNull(user);
	}
	
	//loginするときパスワードが間違っていたテスト
	@Test
	public void testLogin_WrongPassword_Unsuccessful()throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.post("/login/process")
				.param("username", "zhang")
				.param("password", "hina");
		MvcResult result = mockMvc.perform(request)
				.andExpect(redirectedUrl("/login")).andReturn();
		
		//セッション取得
		HttpSession session = result.getRequest().getSession();
		
		//session設定
		UsersEntity user = (UsersEntity)session.getAttribute("users");
		assertNull(user);
	}

}
