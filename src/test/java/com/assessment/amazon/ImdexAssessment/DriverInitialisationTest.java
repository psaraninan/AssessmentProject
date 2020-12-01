package com.assessment.amazon.ImdexAssessment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import resources.DriverInitialisation;

public class DriverInitialisationTest extends DriverInitialisation {
	public static WebDriver driver;

	@BeforeSuite
	public void driverInit() throws IOException {
		driver = driverInitialise();
	}

}
