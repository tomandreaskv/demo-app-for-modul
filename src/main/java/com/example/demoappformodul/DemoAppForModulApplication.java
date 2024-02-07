package com.example.demoappformodul;

import com.example.demomodule.ModuleConfig;
import com.example.demomodule.category.CategoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@EntityScan("com.example.demomodule")
@EnableJpaRepositories("com.example.demomodule")
@SpringBootApplication(scanBasePackages = {"com.example.demoappformodul.category", "com.example.demomodule.category"})
public class DemoAppForModulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppForModulApplication.class, args);
    }

}
