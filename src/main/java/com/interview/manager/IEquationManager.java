package com.interview.manager;

import com.interview.domains.Equations;

public interface IEquationManager {

	void create(Equations equations);
	Equations read(Long id);
	 
}
