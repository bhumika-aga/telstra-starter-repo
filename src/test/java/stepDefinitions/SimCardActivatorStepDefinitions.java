package stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.model.SimCard;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private SimCard simCard;

    @Given("a functional sim card")
    public void aFunctionalSimCard() {
        simCard = new SimCard("1255789453849037777", "horatio.yakima@groovemail.com", false);
    }

    @When("a request to activate the sim card is submitted")
    public void aRequestToActivateSimCard() {
        this.restTemplate.postForObject("http://localhost:8080/activate", simCard, String.class);
    }

    @Then("The sim card is activated and its state is recorded to the database")
    public void theSimCardIsActivated() {
        var simCard = this.restTemplate.getForObject("http://localhost:8080/query?simcardId={simCardId}", SimCard.class,
                1);
        assertTrue(simCard.getActive());
    }

    @Then("The sim card fails to activate and its state is recorded to the database")
    public void theSimCardFailsToActivate() {
        var simCard = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", SimCard.class,
                2);
        assertFalse(simCard.getActive());
    }
}