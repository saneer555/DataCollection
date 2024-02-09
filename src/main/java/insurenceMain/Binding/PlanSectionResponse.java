package insurenceMain.Binding;

import java.util.Map;

import lombok.Data;
@Data
public class PlanSectionResponse {
	
	private Integer caseNum;
	private Map<Integer,String> planNames;

}
