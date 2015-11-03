package org.openqa.selenium.chrome;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.LocationContext;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.html5.RemoteLocationContext;
import org.openqa.selenium.remote.html5.RemoteWebStorage;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

public class ChromeDriver extends RemoteWebDriver implements LocationContext,
		WebStorage {
	private RemoteLocationContext locationContext;
	private RemoteWebStorage webStorage;

	public ChromeDriver() {
		this(ChromeDriverService.createDefaultService(), new ChromeOptions());
	}

	public ChromeDriver(ChromeDriverService service) {
		this(service, new ChromeOptions());
	}

	public ChromeDriver(Capabilities capabilities) {
		this(ChromeDriverService.createDefaultService(), capabilities);
	}

	public ChromeDriver(ChromeOptions options) {
		this(ChromeDriverService.createDefaultService(), options);
	}

	public ChromeDriver(ChromeDriverService service, ChromeOptions options) {
		this(service, options.toCapabilities());
	}

	public ChromeDriver(ChromeDriverService service, Capabilities capabilities) {
		super(new DriverCommandExecutor(service), capabilities);
		this.locationContext = new RemoteLocationContext(getExecuteMethod());
		this.webStorage = new RemoteWebStorage(getExecuteMethod());
	}

	public void setFileDetector(FileDetector detector) {
		throw new WebDriverException(
				"Setting the file detector only works on remote webdriver instances obtained via RemoteWebDriver");
	}

	public LocalStorage getLocalStorage() {
		return this.webStorage.getLocalStorage();
	}

	public SessionStorage getSessionStorage() {
		return this.webStorage.getSessionStorage();
	}

	public Location location() {
		return this.locationContext.location();
	}

	public void setLocation(Location location) {
		this.locationContext.setLocation(location);
	}
}