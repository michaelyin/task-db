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

import org.apache.jackrabbit.uuid.UUID;
import org.exoplatform.commons.utils.ListAccess;
import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.security.Identity;
import org.exoplatform.task.AbstractTest;

import net.wyun.qys.dao.NPolicyHandler;
import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.dao.StandardHandler;
import net.wyun.qys.domain.JcrFileType;
import net.wyun.qys.domain.nationalpolicy.NPJcrFile;
import net.wyun.qys.domain.nationalpolicy.NPSourceType;
import net.wyun.qys.domain.nationalpolicy.NPTag;
import net.wyun.qys.domain.nationalpolicy.NPolicyType;
import net.wyun.qys.domain.nationalpolicy.NationalPolicy;
import net.wyun.qys.domain.standard.StanJcrFile;
import net.wyun.qys.domain.standard.StanTag;
import net.wyun.qys.domain.standard.Standard;
import net.wyun.qys.domain.standard.StandardType;
import net.wyun.qys.util.ListUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="trongtt@exoplatform.com">Trong Tran</a>
 * @version $Revision$
 */
public class TestNationalPolicyDAO extends AbstractTest {

  private NPolicyHandler sDAO;
  private QysDAOHandler daoHandler;

  private final String username = "root";
  

  @Before
  public void setup() {
    PortalContainer container = PortalContainer.getInstance();
    
    daoHandler = (QysDAOHandler) container.getComponentInstanceOfType(QysDAOHandler.class);
    sDAO = daoHandler.getNPolicyHandler(); 
  }

  @After
  public void tearDown() {
	  
    for (NationalPolicy t : sDAO.findAll()) {
      //System.out.print(t.toString());
    	System.out.print(t.getName() + ", " + t.getE_uuid() +  ", " + t.getJcrFiles().toString());
    }    
   
    sDAO.deleteAll();
    
  }

  @Test
  public void testPolicyCreation() {
	  
	  NationalPolicy task = this.createNationalPolicy("国标2015", NPSourceType.上海市);
    sDAO.save(task);

    List<NationalPolicy> list = sDAO.findAll();
    
    for (NationalPolicy t : list) {
        System.out.print(t.toString());
      }    
    
    Assert.assertEquals(1, list.size());

  }

  @Test
  public void testFindStanByType() throws Exception {
	    NationalPolicy task = this.createNationalPolicy("国标2015", NPSourceType.上海市);
	    sDAO.save(task);
	    
	    task = this.createNationalPolicy("国标2014", NPSourceType.北京市);
	    sDAO.save(task);
	    
	    task = this.createNationalPolicy("国标2016", NPSourceType.科技部);
	    sDAO.save(task);

	    List<NationalPolicy> list = sDAO.findAll();
	    
	    for (NationalPolicy t : list) {
	        System.out.println(t.toString());
	      }    
	    
	    Assert.assertEquals(3, list.size());
	    
	    Set<NPSourceType> ss = new HashSet<NPSourceType>();
	    ss.add(NPSourceType.上海市);
	    ss.add(NPSourceType.北京市);
	    
	    list = sDAO.findByTypes(ss);
	    for(NationalPolicy s:list){
	    	System.out.println("type: " + s.getType());
	    }
	    
	    Assert.assertEquals(2, list.size());

  }  

  @Test
  public void testFindTaskOrderByDueDate() throws Exception {
    Calendar calendar = Calendar.getInstance();

    
  }

  
  
  
  @Test
  public void testTaskLog() throws EntityNotFoundException {
   
  }
  
  @Test
  public void testTaskField() throws Exception {
   
  }

  @Test
  public void testSelectFieldInTask() throws Exception {
   
  }
  
  private NationalPolicy createNationalPolicy(String name, NPSourceType type){
	  NationalPolicy s = new NationalPolicy();
	  //s.setName("国家标准2016");
	  s.setName(name);
	  s.setCreateDate(new Date());
	  s.setNum("001-2960-2016");
	  s.setType(NPolicyType.二手车);
	  s.setSource(type);
	  s.setE_uuid("4eb65550-a36a-11e6-80f5-76304dec7eb7");
	  s.setCreator("michaelyin");
	  s.setDepartment("math");
	  
	  NPJcrFile jFile = new NPJcrFile();
	  jFile.setFileName("testfile.txt");
	  jFile.setUploadDate(new Date());
	  jFile.setType(JcrFileType.TEXT);
	  jFile.setUrl("temp/url");
	  jFile.setUuid("4eb65550-a36a-11e6-0000-76304dec7eb7");
	  
	  s.addNPJcrFile(jFile);
	  
	  NPTag sTag1 = new NPTag();
	  sTag1.setTag("first tag: car market 上海");
	  s.addNPTag(sTag1);
	  
	  NPTag sTag = new NPTag();
	  sTag.setTag("second tag: car market 北京");
	  s.addNPTag(sTag);
	  
	  //s.setId(java.util.UUID.randomUUID().toString());
	  
	  return s;
	  
  }

  

  private void assertContain(List<Standard> tasks, String taskId) {
    for(Standard t : tasks) {
      if(t.getId() == taskId) {
        return;
      }
    }
    Assert.fail("Task with ID " + taskId  + " should exist on the list");
  }

  private void assertNotContain(List<Standard> tasks, String taskId) {
    for(Standard t : tasks) {
      if(t.getId() == taskId) {
        Assert.fail("Task with ID " + taskId  + " should not exist on the list");
      }
    }
  }
}
