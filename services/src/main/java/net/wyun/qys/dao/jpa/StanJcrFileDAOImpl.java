package net.wyun.qys.dao.jpa;

import java.util.logging.Logger;

import net.wyun.qys.dao.StanJcrFileHandler;
import net.wyun.qys.domain.standard.StanJcrFile;

public class StanJcrFileDAOImpl extends CommonJPADAO<StanJcrFile, Long> implements StanJcrFileHandler {

	  private static final Logger LOG = Logger.getLogger("StanJcrFileDAOImpl");

	  public StanJcrFileDAOImpl() {
	  }

	  
	  public StanJcrFile update(StanJcrFile entity) {
	    return cloneEntity(super.update(entity));
	  }


	@Override
	public StanJcrFile save(StanJcrFile s) {
		return super.create(s);
	}
}
