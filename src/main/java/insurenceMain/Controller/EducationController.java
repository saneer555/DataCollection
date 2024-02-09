package insurenceMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.EducationData;
import insurenceMain.Services.ApplicantDataCollection;

@RestController
public class EducationController {
	@Autowired
	private ApplicantDataCollection appServices;
	
	@PostMapping("/education")
	public ResponseEntity<Integer>saveEdu(@RequestBody EducationData data){
		Integer educationData = appServices.saveEducationData(data);
		return new ResponseEntity<>(educationData,HttpStatus.CREATED);
	}

}
