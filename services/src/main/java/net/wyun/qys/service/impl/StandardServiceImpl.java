package net.wyun.qys.service.impl;

import javax.inject.Inject;

import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.domain.standard.Standard;
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

}
