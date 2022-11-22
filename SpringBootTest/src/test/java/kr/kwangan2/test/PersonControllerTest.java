package kr.kwangan2.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kr.kwangan2.test.domain.Person;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PersonControllerTest {
   
   @Autowired
   private MockMvc mockMvc;
   
   
   @Test
   public void test() throws Exception{
      mockMvc.perform(get("/hello").param("name", "offset"))
      .andExpect(status().is(200))
      .andExpect(content().string("Hello:offset"))
      .andDo(print());
   }
   
   @Test
   public void testGetPerson() throws Exception{
	      mockMvc.perform(get("/getPerson").param("name", "hong gil dong")
	      													.param("age","20"))
			.andExpect(status().is(200))
	      .andExpect(content().string("{\"name\":\"hong gil dong\",\"age\":20}"))
	      .andDo(print());
	   }
   
   @Test
   public void testGetPersonList() throws Exception{
	   mockMvc.perform(get("/getPersonList")
			   	.param("name[0]", "hong gil dong1")
			   	.param("age[0]","21")
	   			.param("name[1]", "hong gil dong2")
	   			.param("age[1]","22"))
	   .andExpect(status().is(200))
	   .andExpect(content().string("[{\"name\":\"hong gil dong1\",\"age\":21},{\"name\":\"hong gil dong2\",\"age\":22}]"))
	   .andDo(print());
   }

   
   
}//class

