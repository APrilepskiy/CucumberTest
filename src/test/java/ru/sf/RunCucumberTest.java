/*package ru.sf;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@CucumberOptions
public class RunCucumberTest {
}*/
package ru.sf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:ru.sf")
public class RunCucumberTest {
    @AfterClass
    public static void finalizeResources() {
        StepDefinitions.webDriver.close();
    }
}

