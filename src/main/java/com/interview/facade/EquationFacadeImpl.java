package com.interview.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.bean.CoefficientBean;
import com.interview.domains.Equations;
import com.interview.manager.IEquationManager;

@Component
public class EquationFacadeImpl implements IEquationFacade{

	@Autowired
	private IEquationManager equationManager;
	
	@Override
	public void create(CoefficientBean coefficientBean) {
		equationManager.create(coefficientBean);
	}

	@Override
	public Equations read(Long id) {
		return equationManager.read(id);
	}

}
