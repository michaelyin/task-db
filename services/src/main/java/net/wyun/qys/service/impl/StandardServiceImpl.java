package net.wyun.qys.service.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.domain.standard.Standard;
import net.wyun.qys.domain.standard.StandardType;
import net.wyun.qys.service.StandardService;

public class StandardServiceImpl implements StandardService {

	public StandardServiceImpl(QysDAOHandler daoHandler) {
		super();
		this.daoHandler = daoHandler;
	}


	@Inject
	private QysDAOHandler daoHandler;
	
	
	
	@Override
	public Standard save(Standard s) {
		return daoHandler.getStandardHandler().save(s);
	}



	@Override
	public Standard update(Standard s) {
		return daoHandler.getStandardHandler().update(s);
	}



	@Override
	public Standard findById(String uuid) {
		return daoHandler.getStandardHandler().findById(uuid);
	}



	@Override
	public List<Standard> findByTypes(Set<StandardType> types) {
		return daoHandler.getStandardHandler().findByTypes(types);
	}

}
