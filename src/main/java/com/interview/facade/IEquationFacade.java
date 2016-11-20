package com.interview.facade;

import com.interview.domains.Equations;

public interface IEquationFacade {
	
	void create(Equations equations);
	Equations read(Long id);

}
