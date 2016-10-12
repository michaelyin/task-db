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

package net.wyun.qys.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.exoplatform.calendar.service.CalendarService;
import org.exoplatform.commons.api.persistence.ExoTransactional;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.organization.OrganizationService;
import org.exoplatform.social.core.manager.IdentityManager;
import org.exoplatform.social.core.service.LinkProvider;

import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.domain.Policy;
import net.wyun.qys.model.User;
import net.wyun.qys.service.PolicyService;

/**
 * @author <a href="mailto:tuyennt@exoplatform.com">Tuyen Nguyen The</a>.
 */
@Singleton
public class PolicyServiceImpl implements PolicyService {

	private static final Log LOG = ExoLogger.getExoLogger(PolicyServiceImpl.class);

	@Inject
	private OrganizationService orgService;

	@Inject
	private IdentityManager identityManager;

	@Inject
	private QysDAOHandler daoHandler;

	private CalendarService calService;

	public PolicyServiceImpl(OrganizationService orgService, CalendarService calService, IdentityManager idMgr,
			QysDAOHandler handler) {
		this.orgService = orgService;
		this.identityManager = idMgr;
		this.daoHandler = handler;
		this.calService = calService;
	}

	@Override
	@ExoTransactional
	public Policy save(Policy p) {
		LOG.info("save policy: " + p.getPolicyName());
		return daoHandler.getPolicyHandler().save(p);
	}
}
