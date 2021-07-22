package pers.guzx.customersecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "pers.guzx.customersecuritydemo.mapper")
@SpringBootApplication
public class CustomerSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerSecurityDemoApplication.class, args);
    }

}
