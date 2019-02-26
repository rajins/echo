package com.rajins.echo;

import com.rajins.echo.model.DriverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rajins.echo")
public class EchoApplication implements CommandLineRunner {

    @Autowired
    private SeleniumService seleniumService;

    public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String driverType = args[0];
        seleniumService.execute(DriverType.valueOf(driverType));
    }
}
