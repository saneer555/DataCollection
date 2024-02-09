package insurenceMain.Binding;

import java.util.List;

import lombok.Data;

@Data
public class SummaryData {
	
  private IncomeData incomeData;
  
  private EducationData educationData;
  
  private List<ChildsData> childData;
  
  private String planeName;

}
