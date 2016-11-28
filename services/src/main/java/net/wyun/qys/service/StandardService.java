package net.wyun.qys.service;

import java.util.List;
import java.util.Set;

import net.wyun.qys.domain.standard.Standard;
import net.wyun.qys.domain.standard.StandardType;

public interface StandardService {
	
	Standard save(Standard s);
	Standard update(Standard s);

	Standard findById(String uuid);
	List<Standard> findByTypes(Set<StandardType> types);
}
