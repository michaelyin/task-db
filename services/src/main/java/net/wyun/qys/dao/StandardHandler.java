package net.wyun.qys.dao;

import org.exoplatform.commons.api.persistence.GenericDAO;

import net.wyun.qys.domain.standard.Standard;

public interface StandardHandler extends GenericDAO<Standard, Long> {
	  Standard save(Standard p);
	  Standard findById(String uuid);
}
