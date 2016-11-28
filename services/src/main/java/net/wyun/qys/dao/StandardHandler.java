package net.wyun.qys.dao;

import java.util.List;
import java.util.Set;

import org.exoplatform.commons.api.persistence.GenericDAO;

import net.wyun.qys.domain.standard.Standard;
import net.wyun.qys.domain.standard.StandardType;

public interface StandardHandler extends GenericDAO<Standard, Long> {
	  Standard save(Standard p);
	  Standard findById(String uuid);
	  List<Standard> findByTypes(Set<StandardType> types);
}
