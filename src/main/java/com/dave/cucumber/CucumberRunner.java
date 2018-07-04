package com.dave.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by David on 13/10/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/a.feature"},
        glue = {"com.dave.cucumber.features"},
        dryRun = false
)
public class CucumberRunner {
}