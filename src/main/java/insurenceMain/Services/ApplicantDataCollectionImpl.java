package insurenceMain.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurenceMain.Binding.ChildRequest;
import insurenceMain.Binding.ChildsData;
import insurenceMain.Binding.DataApp;
import insurenceMain.Binding.EducationData;
import insurenceMain.Binding.IncomeData;
import insurenceMain.Binding.SummaryData;
import insurenceMain.Entity.ApplicantChildData;
import insurenceMain.Entity.ApplicantData;
import insurenceMain.Entity.ApplicantEducationData;
import insurenceMain.Entity.ApplicantIncomeData;
import insurenceMain.Entity.CreatePlan;
import insurenceMain.Entity.UserApp;
import insurenceMain.Repository.ApplicantChildDataRepository;
import insurenceMain.Repository.ApplicantDataRepository;
import insurenceMain.Repository.ApplicantEducationDataRepository;
import insurenceMain.Repository.ApplicantIncomeDataRepository;
import insurenceMain.Repository.CreatePlanRepository;
import insurenceMain.Repository.UserAppRespository;

@Service
public class ApplicantDataCollectionImpl implements ApplicantDataCollection{
	
	@Autowired
	private UserAppRespository userRepo;
	
	@Autowired
	private ApplicantDataRepository dataRepo;
	
	@Autowired
	private CreatePlanRepository planRepo;
	
	@Autowired
	private ApplicantIncomeDataRepository incomeRepo;
	
	@Autowired
	private ApplicantEducationDataRepository eduRepo;
	
	@Autowired
	private ApplicantChildDataRepository childRepo;

	@Override
	public Integer findByAppId(Integer id) {
		
		Optional<UserApp> id2 = userRepo.findById(id);
		if(id2.isPresent()) {
			ApplicantData data = new ApplicantData();
			data.setAppId(id);
			data = dataRepo.save(data);
			return data.getCaseNum();
			
		}
		
		return 0;
	}

	@Override
	public Map<Integer, String> setplanNames() {
		
		Map<Integer,String> plansMap = new HashMap<>();
		List<CreatePlan> list = planRepo.findAll();
		for(CreatePlan plans : list) {
			plansMap.put(plans.getPlanId(), plans.getPlanName());
		}
		return plansMap;
		
		
	}

	@Override
	public Integer saveplan(DataApp app) {
		ApplicantData data = new ApplicantData();
		BeanUtils.copyProperties(app, data);
		dataRepo.save(data);
		if(data.getCaseNum()!=null) {
		
			return data.getCaseNum();
		}
		return null;
	}

	@Override
	public Integer saveIncomeData(IncomeData income) {
		ApplicantIncomeData data = new ApplicantIncomeData();
		BeanUtils.copyProperties(income, data);
		incomeRepo.save(data);
		if(data.getCaseNum()!=null) {
			return data.getCaseNum();
		}
		
		
		return null;
	}

	@Override
	public Integer saveEducationData(EducationData education) {
		ApplicantEducationData data = new ApplicantEducationData();
		BeanUtils.copyProperties(education, data);
		eduRepo.save(data);
		return data.getCaseNum();
		
	}

	@Override
	public Integer saveChildsData(ChildRequest req) {
		List<ChildsData> childs = req.getChilds(); 
		
		for(ChildsData c : childs) {
			ApplicantChildData data = new ApplicantChildData();
			BeanUtils.copyProperties(c, data);
			childRepo.save(data);	
		}
		return req.getCaseNum();
	}

	@Override
	public SummaryData viewData(Integer caseNum) {
		
		String planName=null;
		
		ApplicantIncomeData incomeDataEntity = incomeRepo.findByCaseNum(caseNum);
		ApplicantEducationData educationDataEntity = eduRepo.findByCaseNum(caseNum);
	  List<ApplicantChildData> childDataEntity = childRepo.findByCaseNum(caseNum);
		ApplicantData applicantData = dataRepo.findByCaseNum(caseNum);
		if(applicantData!=null) {
			Integer planId = applicantData.getPlanId();
			Optional<CreatePlan> id = planRepo.findById(planId);
			if(id.isPresent()) {
				planName=id.get().getPlanName();
				
			}
		}
		
		SummaryData data = new SummaryData();
		data.setPlaneName(planName);
		
		IncomeData income = new IncomeData();
		
		BeanUtils.copyProperties(incomeDataEntity, income);
		data.setIncomeData(income);
		
		
		EducationData eduData = new EducationData();
		
		BeanUtils.copyProperties(educationDataEntity, eduData);
		data.setEducationData(eduData);
		
		
		 List<ChildsData> childDatas = new ArrayList<>();
		    for (ApplicantChildData childDataEntites : childDataEntity) {
		        ChildsData childData = new ChildsData();
		        BeanUtils.copyProperties(childDataEntites, childData);
		        childDatas.add(childData);
		    }
		    data.setChildData(childDatas);
		
		return data;
		
	}
	

}
