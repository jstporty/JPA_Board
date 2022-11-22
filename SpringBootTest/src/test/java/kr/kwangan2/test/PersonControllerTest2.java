package kr.kwangan2.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PersonControllerTest2 {

	@Autowired
	private MockMvc mockMvc;
//
//	@Test
//   public void getViewName() throws Exception {
//	   mockMvc.perform(get("/getViewName"))
//					.andExpect(view().name("testView"));
//	   
//   }
//
//
//	@Test
//	public void getViewName2()  throws Exception{
//		  mockMvc.perform(get("/getViewName2"))
//			.andExpect(view().name("getViewName2"));
//
//	}
//
//	@Test
//	public void getRedirectURL()  throws Exception{
//		  mockMvc.perform(get("/getRedirectURL"))
//			.andExpect(redirectedUrl("/"));
//	}
			
	@Test
	public void getModel() throws Exception{
		  mockMvc.perform(get("/getModel"))
			.andExpect(model().attributeExists("name"))
			.andExpect(model().attribute("name", "YEO"));
}
	

}// class
















