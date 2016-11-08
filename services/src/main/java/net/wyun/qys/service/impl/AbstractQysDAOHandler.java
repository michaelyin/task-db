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
package net.wyun.qys.service.impl;

import net.wyun.qys.dao.PolicyHandler;
import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.dao.StanJcrFileHandler;
import net.wyun.qys.dao.StandardHandler;
import net.wyun.qys.dao.UserSettingHandler;

/**
 */
abstract public class AbstractQysDAOHandler implements QysDAOHandler {

  protected PolicyHandler pHandler;
  protected UserSettingHandler uHandler;
  protected StandardHandler stanHandler;
  protected StanJcrFileHandler stanJcrFileHandler;

  
  public StanJcrFileHandler getStanJcrFileHandler() {
	return stanJcrFileHandler;
}


public PolicyHandler getPolicyHandler() {
    return pHandler;
  }

 
  @Override
  public UserSettingHandler getUserSettingHandler() {
    return uHandler;
  }
  
  public StandardHandler getStandardHandler() {
	  return stanHandler;
  }
}

