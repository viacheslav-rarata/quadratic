package com.interview.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.domains.Equations;

@Component
public class EquationFacadeImpl implements IEquationFacade{

	@Autowired
	private IEquationFacade equationFacade;
	
	@Override
	public void create(Equations equations) {
		 equationFacade.create(equations);
	}

	@Override
	public Equations read(Long id) {
		return equationFacade.read(id);
	}

}
