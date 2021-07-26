package pers.guzx.customersecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Administrator
 */
@MapperScan(basePackages = "pers.guzx.customersecuritydemo.mapper")
@SpringBootApplication
public class CustomerSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerSecurityDemoApplication.class, args);
    }

}
