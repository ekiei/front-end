package login.com.ex.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import login.com.ex.models.entity.UsersEntity;
import login.com.ex.services.UsersService;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UsersService usersService;
	
	@BeforeEach
	private void prepareData() {
//		UsersEntity usersEntity = new UsersEntity("hana","hana@gmail.com","hana111");
		when(usersService.CreatUsers(any(), any(), any())).thenReturn(false);
		when(usersService.CreatUsers(eq("hana"),eq("hana111") ,eq("hana@gmail.com"))).thenReturn(true);
	}
	
	//register画面表示テスト
	@Test
	public void testGetRegisterPage_Succeed()throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/register");
		mockMvc.perform(request)
		.andExpect(view().name("register.html"));
	}
	
	//登録画面ができるテスト@PostMapping("/register")
	@Test
	public void testRegister_Succeed()throws Exception{
		RequestBuilder requester = MockMvcRequestBuilders
				.post("/register/process")
				.param("username", "hana")
				.param("password", "hana111")
				.param("email","hana@gmail.com" );
		mockMvc.perform(requester)
		.andExpect(view().name("login.html"));
	}
	
	//登録画面ができるテスト@PostMapping("/register")
	@Test
	public void testRegister_Fail()throws Exception{
		RequestBuilder requester = MockMvcRequestBuilders
				.post("/register/process")
				.param("username", "hina")
				.param("password", "hana111")
				.param("email","hana@gmail.com" );
		mockMvc.perform(requester)
		.andExpect(view().name("register.html"));
	}
}
