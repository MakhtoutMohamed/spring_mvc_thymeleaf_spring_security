package com.vogdo.springmvcthymeleafspringsecurity;

import com.vogdo.springmvcthymeleafspringsecurity.entities.Product;
import com.vogdo.springmvcthymeleafspringsecurity.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.core.userdetails.User;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class SpringMvcThymeleafSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafSpringSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository, JdbcUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Computer")
                            .price(5400)
                            .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smartphone")
                    .price(1200)
                    .quantity(33)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });

            //
            if (!userDetailsManager.userExists("user1")) {
                userDetailsManager.createUser(
                        User.withUsername("user1").password(passwordEncoder.encode("12345")).roles("USER").build()
                );
            }
            if (!userDetailsManager.userExists("admin")) {
                userDetailsManager.createUser(
                        User.withUsername("admin").password(passwordEncoder.encode("12345")).roles("USER", "ADMIN").build()
                );
            }
        };
    }

}
