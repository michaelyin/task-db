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

import net.wyun.qys.dao.LPolicyHandler;
import net.wyun.qys.domain.localpolicy.LPSourceType;
import net.wyun.qys.domain.localpolicy.LocalPolicy;
import net.wyun.qys.domain.nationalpolicy.NPSourceType;
import net.wyun.qys.domain.nationalpolicy.NationalPolicy;

/**
 * Created by The eXo Platform SAS Author : Thibault Clement
 * tclement@exoplatform.com 4/10/15
 */
public class LPolicyDAOImpl extends CommonJPADAO<LocalPolicy, Long> implements LPolicyHandler {

	private static final Logger LOG = Logger.getLogger("LPolicyDAOImpl");

	public LPolicyDAOImpl() {
	}

	public LocalPolicy update(LocalPolicy entity) {
		return cloneEntity(super.update(entity));
	}

	@Override
	public LocalPolicy save(LocalPolicy p) {
		return super.create(p);
	}

	@Override
	public LocalPolicy findById(String uuid) {
		return super.getEntityManager().find(LocalPolicy.class, uuid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocalPolicy> findByTypes(Set<LPSourceType> types) {
		if(types.isEmpty()){
			//select all
			return this.findAll();
		}
		
		final String paraQuery = "From LocalPolicy np WHERE np.source in :selected";
		return (List<LocalPolicy>) getEntityManager().createQuery(paraQuery)
				.setParameter("selected", types)
				.getResultList();
	}

}
