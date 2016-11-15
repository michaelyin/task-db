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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.exoplatform.commons.utils.ListAccess;

import net.wyun.qys.dao.OrderBy;
import net.wyun.qys.dao.PolicyHandler;
import net.wyun.qys.dao.condition.Conditions;
import net.wyun.qys.dao.condition.SingleCondition;
import net.wyun.qys.domain.Policy;

/**
 * Created by The eXo Platform SAS
 * Author : Thibault Clement
 * tclement@exoplatform.com
 * 4/10/15
 */
public class PolicyDAOImpl extends CommonJPADAO<Policy, Long> implements PolicyHandler {

  private static final Logger LOG = Logger.getLogger("PolicyDAOImpl");

  public PolicyDAOImpl() {
  }

  
  public Policy update(Policy entity) {
    return cloneEntity(super.update(entity));
  }

@Override
public Policy save(Policy p) {
	
	return super.create(p);
}

  
}