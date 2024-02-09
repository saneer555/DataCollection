package insurenceMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.ChildRequest;
import insurenceMain.Binding.SummaryData;
import insurenceMain.Services.ApplicantDataCollection;

@RestController
public class ChildController {
	
	@Autowired
	private ApplicantDataCollection appServices;
	
	@PostMapping("/childs")
	public ResponseEntity<SummaryData>saveChilds(@RequestBody ChildRequest req){
		Integer saveChildsData = appServices.saveChildsData(req);
		SummaryData viewData = appServices.viewData(saveChildsData);
		
		return new ResponseEntity<>(viewData,HttpStatus.OK);
	}

}
