package StepDefenition;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSD {
	
	@Given("I have the below Values:")
	public void i_have_the_below_values(io.cucumber.datatable.DataTable dataTable) {
List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
        
        // Iterate over the list and print user details
        for (Map<String, String> user : users) {
            String username = user.get("username");
            String password = user.get("password");
            System.out.println("Username: " + username + ", Password: " + password);
            
            // Add code here to handle the user login setup
        }
	}
	
	
	@When("Post request is sent")
	public void post_request_is_sent() {
	   System.out.println("Post");
	}

	@Then("verify status code {int}")
	public void verify_status_code(Integer int1) {
	    System.out.println("200OK");
	}




}
