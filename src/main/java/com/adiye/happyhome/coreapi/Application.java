package com.adiye.happyhome.coreapi;

import org.springframework.boot.SpringApplication;
import com.adiye.happyhome.coreapi.utils.DBConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DBConfiguration.class)
public class Application {
    
    public static void main(String[] args) {    	
        SpringApplication.run(Application.class, args);        
    }
}