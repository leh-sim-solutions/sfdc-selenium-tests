package org.fundacionjala.sfdc.core.driver;


import org.fundacionjala.sfdc.util.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * DriverManager.java.
 * Class that applies Singleton pattern to instance WebDriver only once.
 */
public final class DriverManager {
    private static final PropertiesManager PROPERTIES_MANAGER = PropertiesManager.getInstance();
    private static final int EXPLICIT_TIME = PROPERTIES_MANAGER.getExplicitTime();
    private static final int IMPLICIT_TIME = PROPERTIES_MANAGER.getImplicitTime();
    private static DriverManager driverManager;
    private WebDriver driver;
    private WebDriverWait wait;


    /**
     * Constructor, private to apply singleton pattern.
     */
    private DriverManager() {
        DriverType driverType = DriverType.valueOf(PropertiesManager.getInstance().getBrowser());
        driver = DriverFactory.getDriverManager(driverType);
        wait = new WebDriverWait(driver, EXPLICIT_TIME);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
    }

    /**
     * Static method to get an class instance.
     *
     * @return instance.
     */
    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    /**
     * Getter of WebDriver object.
     *
     * @return WebDriver instance.
     */
    public WebDriver getNavigator() {
        return driver;
    }

    /**
     * Getter of WebDriverWait object.
     *
     * @return WebDriverWait instance.
     */
    public WebDriverWait getWaiter() {
        return wait;
    }

    /**
     * Set time implicit wait.
     *
     * @param implicitTimeWait time for wait.
     */
    public void setImplicitTime(int implicitTimeWait) {
        driver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }
}
