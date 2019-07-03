package com.whchao.demo;


import com.whchao.demo.webservices.client.CountryClient;
import com.whchao.demo.webservices.service.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling  //启动定时任务
@MapperScan("com.whchao.demo.dao")
public class DemoApplication
//        extends SpringBootServletInitializer
{

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DemoApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner lookup(CountryClient quoteClient) {
//        return args -> {
//            String country = "Spain";
//
//            if (args.length > 0) {
//                country = args[0];
//            }
//            GetCountryResponse response = quoteClient.getCountry(country);
//            System.err.println(response.getCountry().getCurrency());
//        };
//    }
}
