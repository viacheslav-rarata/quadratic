package com.interview.manager;

import java.util.Date;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.bean.CoefficientBean;
import com.interview.dao.IEquationDao;
import com.interview.domains.Equations;
import com.interview.rule.GeneralRule;
import com.interview.rule.IQudraticRule;

@Service
@Transactional
public class EquationManagerImpl implements IEquationManager {
	
	@Autowired
	private IEquationDao euqationDao;
	@Override
	public void create(CoefficientBean coefficientBean) {
		 Equations equations = parseCoefficientBeanToEquation(findResult(coefficientBean));
		 euqationDao.create(equations);
	}

	@Override
	public Equations read(Long id) {
		return euqationDao.read(id);
	}
	private CoefficientBean findResult(CoefficientBean coefficientBean){
		IQudraticRule rule = new GeneralRule();
		return rule.getResult(coefficientBean);
	}
	private Equations parseCoefficientBeanToEquation(CoefficientBean coefficientBean){
		Equations equations = new Equations();
		equations.setLeadinCoefficient(Double.parseDouble(coefficientBean.getLeadingCoefficien()));
		equations.setSecondCoefficient(Double.parseDouble(coefficientBean.getSecondCoefficien()));
		equations.setFreeMember(Double.parseDouble(coefficientBean.getFreeMember()));
		equations.setFirstVariable(coefficientBean.getFirstVariable());
		equations.setSecondVariable(coefficientBean.getSecondVariable());
		equations.setCreatedDate(new Date());
		return equations;
	}
}
