package com.interview.dao;

import java.util.List;

import com.interview.domains.Equations;

public interface IEquationDao {
	
	void create(Equations equations);
	Equations read(Long id);
	List<Equations> read(); 
	void update(Equations equations);
	void delete(Equations equations);

}
