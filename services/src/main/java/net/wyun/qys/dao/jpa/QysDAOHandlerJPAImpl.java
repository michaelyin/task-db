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

import javax.inject.Singleton;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.dao.StandardHandler;
import net.wyun.qys.domain.UserSetting;
import net.wyun.qys.service.impl.AbstractQysDAOHandler;

/**
 * Created by The eXo Platform SAS
 * Author : Thibault Clement
 * tclement@exoplatform.com
 * 4/8/15
 */
@Singleton
public class QysDAOHandlerJPAImpl extends AbstractQysDAOHandler implements QysDAOHandler {

  private static final Log LOG = ExoLogger.getLogger("QysDAOHandlerJPAImpl");

  public QysDAOHandlerJPAImpl() {
    LOG.info("QysDAOHandlerJPAImpl is creating...");
    
    pHandler = new NPolicyDAOImpl();
    uHandler = new UserSettingDAO();
    stanHandler = new StandardDAOImpl();
    stanJcrFileHandler = new StanJcrFileDAOImpl();
    LOG.info("QysDAOHandlerJPAImpl is created");
  }
  
  public static <E> E clone(E e) {
	    if (e == null) return null;
	    if (e instanceof UserSetting) {
	      return (E)((UserSetting)e).clone();
	    }

	    return e;
	  }


}

