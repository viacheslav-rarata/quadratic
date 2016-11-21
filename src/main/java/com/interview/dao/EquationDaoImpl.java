package com.interview.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.interview.domains.Equations;

@Repository
public class EquationDaoImpl implements IEquationDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void create(Equations equations) {
		entityManager.persist(equations);
	}

	@Override
	public Equations read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equations> read() {
		List<Equations> equations = entityManager.createQuery("from Equations").getResultList();
		return equations;
	}

	@Override
	public void update(Equations equations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Equations equations) {
		// TODO Auto-generated method stub
		
	}

}
