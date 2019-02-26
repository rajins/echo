package com.rajins.echo.model;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;

public interface IDriver extends WebDriver, JavascriptExecutor, HasCapabilities, HasInputDevices {
}