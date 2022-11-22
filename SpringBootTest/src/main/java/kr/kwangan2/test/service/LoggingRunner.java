package kr.kwangan2.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner {

   private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
   
   @Override
   public void run(ApplicationArguments args) throws Exception {
      logger.trace("trace 로그입니다");
      logger.debug("debug 로그입니다");
      logger.info("info 로그입니다");
      logger.warn("warn 로그입니다");
      logger.error("error 로그입니다");
      
   }

}