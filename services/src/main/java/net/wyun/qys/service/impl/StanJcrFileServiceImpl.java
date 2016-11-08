package net.wyun.qys.service.impl;

import javax.inject.Inject;

import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.domain.standard.StanJcrFile;
import net.wyun.qys.service.StanJcrFileService;

public class StanJcrFileServiceImpl implements StanJcrFileService{
	
	public StanJcrFileServiceImpl(QysDAOHandler daoHandler) {
		super();
		this.daoHandler = daoHandler;
	}


	@Inject
	private QysDAOHandler daoHandler;
	
	
	
	@Override
	public StanJcrFile save(StanJcrFile s) {
		return daoHandler.getStanJcrFileHandler().save(s);
	}

}
