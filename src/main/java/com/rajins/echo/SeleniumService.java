package com.rajins.echo;

import com.rajins.echo.factories.DriverFactory;
import com.rajins.echo.model.DriverType;
import com.rajins.echo.model.IDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumService {

    @Autowired
    private DriverFactory driverFactory;

    public void execute(DriverType driverType) throws InterruptedException {
        IDriver webDriver = driverFactory.getWebDriverFor(driverType);
        String baseUrl = "<TOBE GIVEN>";
        webDriver.manage().window().maximize();
        webDriver.get(baseUrl);
        Thread.sleep(5000);

        WebElement element = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/ul/li[3]/span/a"));
        element.click();
        Thread.sleep(15000);

        element = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/table/tbody/tr[2]/td[1]/div/div"));
        element.click();
        Thread.sleep(1000);

        element = webDriver.findElement(By.xpath("//*[@id=\"actionMenu-1913-btnInnerEl\"]"));
        element.click();
        Thread.sleep(1000);

        Actions actions = new Actions(webDriver);
        element = webDriver.findElement(By.xpath("//*[@id=\"menuitem-1915\"]"));
        actions.moveToElement(element).perform();
        Thread.sleep(1000);

        element = webDriver.findElement(By.xpath("//*[@id=\"siteCloneAction-1919-itemEl\"]"));
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
        actions.click().perform();
        Thread.sleep(2000);

        element = webDriver.findElement(By.xpath("//*[@id=\"numberOfClone\"]"));
        Select select = new Select(element);
        select.selectByVisibleText("2");
        Thread.sleep(1000);

        element = webDriver.findElement(By.xpath("//*[@id=\"button-1005-btnIconEl\"]"));
        element.click();
        Thread.sleep(15000);

        element = webDriver.findElement(By.xpath("//*[@id=\"button-1005-btnIconEl\"]"));
        element.click();
        Thread.sleep(5000);

        webDriver.close();
    }
}
