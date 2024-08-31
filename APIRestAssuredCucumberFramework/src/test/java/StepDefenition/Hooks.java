package StepDefenition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void BeforeScenario() throws IOException {
		// Code to Give PlaceID only when placeid is null
		StepDef1 StepDef1Obj = new StepDef1();
		// For static variable its suggested to use Class name instead of object to call
		
		if (StepDef1.PlaceID == null) {
			StepDef1Obj.add_place_payload_with("BADBOY", "French", "Australia");
			StepDef1Obj.user_calls_with_http_request("AddPlaceAPI", "POST");
			StepDef1Obj.verify_if_placea_id_is_added_successfuly_for_using("BADBOY", "GetPlaceAPI");
		}

	}
}
