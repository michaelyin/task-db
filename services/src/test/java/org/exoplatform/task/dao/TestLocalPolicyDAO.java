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
package org.exoplatform.task.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.EntityNotFoundException;

import org.exoplatform.container.PortalContainer;
import org.exoplatform.task.AbstractTest;

import net.wyun.qys.dao.LPolicyHandler;
import net.wyun.qys.dao.NPolicyHandler;
import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.domain.JcrFileType;
import net.wyun.qys.domain.localpolicy.LPJcrFile;
import net.wyun.qys.domain.localpolicy.LPSourceType;
import net.wyun.qys.domain.localpolicy.LPTag;
import net.wyun.qys.domain.localpolicy.LPolicyType;
import net.wyun.qys.domain.localpolicy.LocalPolicy;
import net.wyun.qys.domain.nationalpolicy.NPJcrFile;
import net.wyun.qys.domain.nationalpolicy.NPSourceType;
import net.wyun.qys.domain.nationalpolicy.NPTag;
import net.wyun.qys.domain.nationalpolicy.NPolicyType;
import net.wyun.qys.domain.nationalpolicy.NationalPolicy;
import net.wyun.qys.util.ListUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author michaelyin
 * @version $Revision$
 */
public class TestLocalPolicyDAO extends AbstractTest {

  private LPolicyHandler sDAO;
  private QysDAOHandler daoHandler;

  private final String username = "root";
  

  @Before
  public void setup() {
    PortalContainer container = PortalContainer.getInstance();
    
    daoHandler = (QysDAOHandler) container.getComponentInstanceOfType(QysDAOHandler.class);
    sDAO = daoHandler.getLPolicyHandler(); 
  }

  @After
  public void tearDown() {
	  
    for (LocalPolicy t : sDAO.findAll()) {
      //System.out.print(t.toString());
    	System.out.print(t.getName() + ", " + t.getE_uuid() +  ", " + t.getJcrFiles().toString());
    }    
   
    sDAO.deleteAll();
    
  }

  @Test
  public void testPolicyCreation() {
	  
	LocalPolicy task = this.createLocalPolicy("国标2015", LPSourceType.工信厅);
    sDAO.save(task);

    List<LocalPolicy> list = sDAO.findAll();
    
    for (LocalPolicy t : list) {
        System.out.print(t.toString());
      }    
    
    Assert.assertEquals(1, list.size());

  }

  @Test
  public void testFindStanByType() throws Exception {
	  LocalPolicy task = this.createLocalPolicy("国标2015", LPSourceType.能源局);
	    sDAO.save(task);
	    
	    task = this.createLocalPolicy("国标2014", LPSourceType.科技厅);
	    sDAO.save(task);
	    
	    task = this.createLocalPolicy("国标2016", LPSourceType.工信厅);
	    sDAO.save(task);

	    List<LocalPolicy> list = sDAO.findAll();
	    
	    for (LocalPolicy t : list) {
	        System.out.println(t.toString());
	      }    
	    
	    Assert.assertEquals(3, list.size());
	    
	    Set<LPSourceType> ss = new HashSet<LPSourceType>();
	    ss.add(LPSourceType.能源局);
	    ss.add(LPSourceType.科技厅);
	    
	    list = sDAO.findByTypes(ss);
	    for(LocalPolicy s:list){
	    	System.out.println("type: " + s.getType());
	    }
	    
	    Assert.assertEquals(2, list.size());

  }  

    
  private LocalPolicy createLocalPolicy(String name, LPSourceType type){
	  LocalPolicy s = new LocalPolicy();
	  //s.setName("国家标准2016");
	  s.setName(name);
	  s.setCreateDate(new Date());
	  s.setNum("001-2960-2016");
	  s.setType(LPolicyType.二手车);
	  s.setSource(type);
	  s.setE_uuid("4eb65550-a36a-11e6-80f5-76304dec7eb7");
	  s.setCreator("michaelyin");
	  s.setDepartment("math");
	  s.setCity("南昌");
	  s.setProvince("江西");
	  
	  LPJcrFile jFile = new LPJcrFile();
	  jFile.setFileName("testfile.txt");
	  jFile.setUploadDate(new Date());
	  jFile.setType(JcrFileType.TEXT);
	  jFile.setUrl("temp/url");
	  jFile.setUuid("4eb65550-a36a-11e6-0000-76304dec7eb7");
	  
	  s.addLPJcrFile(jFile);
	  
	  LPTag sTag1 = new LPTag();
	  sTag1.setTag("first tag: car market 上海");
	  s.addLPTag(sTag1);
	  
	  LPTag sTag = new LPTag();
	  sTag.setTag("second tag: car market 北京");
	  s.addLPTag(sTag);
	  
	  //s.setId(java.util.UUID.randomUUID().toString());
	  
	  return s;
	  
  }
  

 }
