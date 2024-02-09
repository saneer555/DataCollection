package insurenceMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.IncomeData;
import insurenceMain.Services.ApplicantDataCollection;
@RestController
public class IncomeController {
	@Autowired
	private ApplicantDataCollection appServices;
	
	@PostMapping("/income")
	public ResponseEntity<Integer>saveIncome(@RequestBody IncomeData data){
		
		Integer incomeData = appServices.saveIncomeData(data);
		return new ResponseEntity<>(incomeData,HttpStatus.CREATED);
	}

}
