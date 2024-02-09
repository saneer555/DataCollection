package insurenceMain.Binding;

import java.util.List;

import lombok.Data;

@Data
public class ChildRequest {
	
	private Integer caseNum;
	
	private List<ChildsData> childs;

}
