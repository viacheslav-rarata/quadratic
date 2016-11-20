package com.interview.manager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.dao.IEquationDao;
import com.interview.domains.Equations;

@Service
@Transactional
public class EquationManagerImpl implements IEquationManager {

	@Autowired
	private IEquationDao euqationDao;
	@Override
	public void create(Equations equations) {
		 euqationDao.create(equations);
	}

	@Override
	public Equations read(Long id) {
		return euqationDao.read(id);
	}

}
