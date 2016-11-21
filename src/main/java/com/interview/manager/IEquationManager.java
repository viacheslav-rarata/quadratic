package com.interview.manager;

import com.interview.bean.CoefficientBean;
import com.interview.domains.Equations;

public interface IEquationManager {

	void create(CoefficientBean coefficientBean);
	Equations read(Long id);
	 
}
