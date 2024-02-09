package insurenceMain.Services;

import java.util.Map;

import insurenceMain.Binding.ChildRequest;
import insurenceMain.Binding.DataApp;
import insurenceMain.Binding.EducationData;
import insurenceMain.Binding.IncomeData;
import insurenceMain.Binding.SummaryData;

public interface ApplicantDataCollection {
	
	public Integer findByAppId(Integer id);
	
	public Map<Integer, String>setplanNames();
	
	public Integer saveplan(DataApp app);
	
	public Integer saveIncomeData(IncomeData income);
	
	public Integer saveEducationData(EducationData education);
	
	public Integer saveChildsData(ChildRequest req);
	
	public SummaryData viewData(Integer caseNum);

}
