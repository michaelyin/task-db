/*
 * Copyright (C) 2015 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.wyun.qys.dao;

import java.util.List;
import java.util.Set;

import org.exoplatform.commons.api.persistence.GenericDAO;

import net.wyun.qys.domain.Policy;
import net.wyun.qys.domain.localpolicy.LPSourceType;
import net.wyun.qys.domain.localpolicy.LocalPolicy;
import net.wyun.qys.domain.nationalpolicy.NPSourceType;
import net.wyun.qys.domain.nationalpolicy.NationalPolicy;
import net.wyun.qys.domain.standard.Standard;
import net.wyun.qys.domain.standard.StandardType;

/**
 */
public interface LPolicyHandler extends GenericDAO<LocalPolicy, Long> {
	LocalPolicy save(LocalPolicy p);
	LocalPolicy findById(String uuid);
	List<LocalPolicy> findByTypes(Set<LPSourceType> types);
}
