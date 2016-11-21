package com.interview.facade;

import com.interview.bean.CoefficientBean;
import com.interview.domains.Equations;

public interface IEquationFacade {
	
	void create(CoefficientBean coefficientBean);
	Equations read(Long id);

}
