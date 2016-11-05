package net.wyun.qys.dao.jpa;

import java.util.logging.Logger;

import net.wyun.qys.dao.StandardHandler;
import net.wyun.qys.domain.standard.Standard;

public class StandardDAOImpl extends CommonJPADAO<Standard, Long> implements StandardHandler {

	  private static final Logger LOG = Logger.getLogger("StandardDAOImpl");

	  public StandardDAOImpl() {
	  }

	  
	  public Standard update(Standard entity) {
	    return cloneEntity(super.update(entity));
	  }


	@Override
	public Standard save(Standard p) {
		return super.create(p);
	}
	  
	  
}
