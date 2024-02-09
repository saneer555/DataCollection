package insurenceMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.DataApp;
import insurenceMain.Services.ApplicantDataCollection;

@RestController
public class PlanSelectionController {
	@Autowired
	private ApplicantDataCollection appServices;
	
	@PostMapping("/createCase")
	public ResponseEntity<Integer>planSelection(@RequestBody DataApp app){
		Integer saveplan = appServices.saveplan(app);
		return new ResponseEntity<>(saveplan,HttpStatus.CREATED);
	}

}
