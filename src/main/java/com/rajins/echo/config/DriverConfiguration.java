package com.rajins.echo.config;

import com.rajins.echo.annotations.Chrome;
import com.rajins.echo.annotations.Gecko;
import com.rajins.echo.annotations.InternetExplorer;
import com.rajins.echo.drivers.EchoChromeDriver;
import com.rajins.echo.drivers.EchoFirefoxDriver;
import com.rajins.echo.model.IDriver;
import org.springframework.context.annotation.*;

@Configuration
public class DriverConfiguration {

    @Bean
    @Chrome
    @Lazy
    public IDriver theChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        return new EchoChromeDriver();
    }

    @Bean
    @InternetExplorer
    @Lazy
    public IDriver theIEDriver() {
        System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
        return new EchoChromeDriver();
    }

    @Bean
    @Gecko
    @Lazy
    public IDriver theFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        return new EchoFirefoxDriver();
    }
}
