package com.rajins.echo.factories;

import com.rajins.echo.annotations.Chrome;
import com.rajins.echo.annotations.Gecko;
import com.rajins.echo.annotations.InternetExplorer;
import com.rajins.echo.model.DriverType;
import com.rajins.echo.model.IDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Component
public class DriverFactory {

    private Map<DriverType, Supplier<IDriver>> driverSupplierMap;

    @Autowired
    @Chrome
    @Lazy
    private IDriver theChromeDriver;

    @Autowired
    @InternetExplorer
    @Lazy
    private IDriver theIEDriver;

    @Autowired
    @Gecko
    @Lazy
    private IDriver theFirefoxDriver;

    @PostConstruct
    private void construct() {
        driverSupplierMap = Collections.unmodifiableMap(new HashMap<DriverType, Supplier<IDriver>>() {{
            put(DriverType.CHROME, () -> theChromeDriver);
            put(DriverType.IE, () -> theIEDriver);
            put(DriverType.GECKO, () -> theFirefoxDriver);
        }});
    }

    public IDriver getWebDriverFor(DriverType driverType) {
        assert driverType != null : "Type of the driver must be specified!";
        Supplier<IDriver> webDriverSupplier = driverSupplierMap.get(driverType);
        assert webDriverSupplier != null : "Implementation not found for the specified driver type!";
        return webDriverSupplier.get();
    }
}
