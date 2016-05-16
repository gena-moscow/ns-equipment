package ru.nefrosovet.nsequipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class AppEquipmentService extends SpringBootServletInitializer {

    public AppEquipmentService() {
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppEquipmentService.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppEquipmentService.class, args);
    }
}
