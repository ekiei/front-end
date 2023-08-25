package login.com.ex.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import login.com.ex.models.entity.BlogEntity;
import login.com.ex.services.BlogService;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BlogService blogService; 
	
	
//	@BeforeEach
//	private void prepareData() {
//		BlogEntity blogEntity = new BlogEntity("0825","z.jpn","a","a");
//		when(blogService.createBlog(any(), any(), any(), any())).thenReturn(blogEntity);
//	}
	
	@Test
	public void testGetFrontPage_Succeed()throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/front");
		
	}
}
