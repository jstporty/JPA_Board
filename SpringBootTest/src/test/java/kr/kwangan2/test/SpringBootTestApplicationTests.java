package kr.kwangan2.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.test.controller.PersonController;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes=PersonController.class,
		properties= {
				"author.name=takeoff",
				"author.age=45",
				"author.nation=USA	"
			})
@Log4j2
class SpringBootTestApplicationTests {

	@Autowired
	Environment enviroment;

	@Test
	void getProperties() {
		
		log.info("이름 :"+ enviroment.getProperty("author.name"));
		log.info("나이 :"+ enviroment.getProperty("author.age"));
		log.info("국적 :"+ enviroment.getProperty("author.nation"));
		
	}

}
