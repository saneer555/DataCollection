package insurenceMain.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.PlanSectionResponse;
import insurenceMain.Services.ApplicantDataCollection;

@RestController
public class DataAppController {
	
	@Autowired
	private ApplicantDataCollection appServices;
	
	@GetMapping("/app/{id}")
	public ResponseEntity<Integer>createCase(@PathVariable Integer id){
		Integer appId = appServices.findByAppId(id);
		Map<Integer, String> setplanNames = appServices.setplanNames();
		
		PlanSectionResponse response = new PlanSectionResponse();
		response.setCaseNum(appId);
		response.setPlanNames(setplanNames);
		
		return new ResponseEntity<>(appId,HttpStatus.OK);
		
	}

}
