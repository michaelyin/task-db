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

import net.wyun.qys.dao.QysDAOHandler;
import net.wyun.qys.dao.StandardHandler;
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
public class TestStandardDAO extends AbstractTest {

  private StandardHandler sDAO;
  private QysDAOHandler daoHandler;

  private final String username = "root";
  

  @Before
  public void setup() {
    PortalContainer container = PortalContainer.getInstance();
    
    daoHandler = (QysDAOHandler) container.getComponentInstanceOfType(QysDAOHandler.class);
    sDAO = daoHandler.getStandardHandler(); 
  }

  @After
  public void tearDown() {
	  
    for (Standard t : sDAO.findAll()) {
      //System.out.print(t.toString());
    	System.out.print(t.getName() + ", " + t.getUuid() +  ", " + t.getStanJcrFiles().toString());
    }    
   
    sDAO.deleteAll();
    
  }

  @Test
  public void testTaskCreation() {
	  
    Standard task = this.createStandard();
    sDAO.save(task);

    List<Standard> list = sDAO.findAll();
    
    for (Standard t : list) {
        System.out.print(t.toString());
      }    
    
    Assert.assertEquals(1, list.size());

    /*
    task = parser.parse("There is an important meeting tomorrow !high", context);
    tDAO.create(task);
    list = tDAO.findAll();
    Assert.assertEquals(2, list.size());

    //
    task = tDAO.find(task.getId());
    Assert.assertNotNull(task);
    Assert.assertEquals("There is an important meeting tomorrow", task.getTitle());
    Assert.assertEquals(Priority.HIGH, task.getPriority());
    */
  }

  @Test
  public void testFindTaskByQuery() throws Exception {
   // Task task = newTaskInstance("Test find task by query", "description of find task by query", "root");
   // tDAO.create(task);

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
  
  private Standard createStandard(){
	  Standard s = new Standard();
	  s.setName("国家标准2016");
	  s.setCreateDate(new Date());
	  s.setNum("001-2960-2016");
	  s.setType(StandardType.专用车);
	  s.setUuid("4eb65550-a36a-11e6-80f5-76304dec7eb7");
	  s.setCreator("michaelyin");
	  s.setDepartment("math");
	  
	  StanJcrFile jFile = new StanJcrFile();
	  jFile.setFileName("testfile.txt");
	  jFile.setUploadDate(new Date());
	  jFile.setUrl("temp/url");
	  jFile.setUuid("4eb65550-a36a-11e6-0000-76304dec7eb7");
	  
	  s.addStanJcrFile(jFile);
	  
	  StanTag sTag1 = new StanTag();
	  sTag1.setTag("first tag: car market 上海");
	  s.addStanTag(sTag1);
	  
	  StanTag sTag = new StanTag();
	  sTag.setTag("second tag: car market 北京");
	  s.addStanTag(sTag);
	  
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
