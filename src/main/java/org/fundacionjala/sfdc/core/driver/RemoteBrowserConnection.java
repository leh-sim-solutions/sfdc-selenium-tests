package org.fundacionjala.sfdc.core.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.sfdc.util.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This abstract class implements methods to use in SauceLabs and Browser Stack connection.
 */
public abstract class RemoteBrowserConnection implements Browser {

    protected static final PropertiesConfig PROPERTIES_MANAGER = PropertiesConfig.getInstance();
    protected static final String USERNAME = PROPERTIES_MANAGER.getRemoteUserName();
    protected static final String ACCESS_KEY = PROPERTIES_MANAGER.getRemoteAccessKey();
    private static final Logger LOGGER = LogManager.getLogger(RemoteBrowserConnection.class);
    private final String url;


    /**
     * This method setCapabilities the remote browser.
     * @return capabilities.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * This is the constructor.
     *
     * @param url url connection.
     */
    public RemoteBrowserConnection(final String url) {
        this.url = url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("URL not valid:", e);
        }
        return driver;
    }

}
