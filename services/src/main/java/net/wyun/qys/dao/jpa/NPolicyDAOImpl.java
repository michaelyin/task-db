/* 
* Copyright (C) 2003-2015 eXo Platform SAS.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see http://www.gnu.org/licenses/ .
*/
package net.wyun.qys.dao.jpa;



import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import net.wyun.qys.dao.NPolicyHandler;
import net.wyun.qys.domain.nationalpolicy.NPSourceType;
import net.wyun.qys.domain.nationalpolicy.NationalPolicy;

/**
 * Created by The eXo Platform SAS Author : Thibault Clement
 * tclement@exoplatform.com 4/10/15
 */
public class NPolicyDAOImpl extends CommonJPADAO<NationalPolicy, Long> implements NPolicyHandler {

	private static final Logger LOG = Logger.getLogger("PolicyDAOImpl");

	public NPolicyDAOImpl() {
	}

	public NationalPolicy update(NationalPolicy entity) {
		return cloneEntity(super.update(entity));
	}

	@Override
	public NationalPolicy save(NationalPolicy p) {

		return super.create(p);
	}

	@Override
	public NationalPolicy findById(String uuid) {
		return super.getEntityManager().find(NationalPolicy.class, uuid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NationalPolicy> findByTypes(Set<NPSourceType> types) {
		if(types.isEmpty()){
			//select all
			return this.findAll();
		}
		
		final String paraQuery = "From NationalPolicy np WHERE np.source in :selected";
		return (List<NationalPolicy>) getEntityManager().createQuery(paraQuery)
				.setParameter("selected", types)
				.getResultList();
	}

}
