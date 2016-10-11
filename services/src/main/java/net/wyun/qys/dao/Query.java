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

import static net.wyun.qys.dao.condition.Conditions.and;
import static net.wyun.qys.dao.condition.Conditions.eq;

import java.util.ArrayList;
import java.util.List;

import net.wyun.qys.dao.condition.AggregateCondition;
import net.wyun.qys.dao.condition.Condition;
import net.wyun.qys.dao.condition.Conditions;

public abstract class Query implements Cloneable {

  private AggregateCondition aggCondition = null;
  private List<OrderBy> orderBy = new ArrayList<OrderBy>();

  public Query() {}
  
  public Query(AggregateCondition aggCondition, List<OrderBy> orderBy) {
    super();
    this.aggCondition = aggCondition;
    this.orderBy = orderBy;
  }
  
  public void setId(long taskId) {
    this.add(eq(Conditions.ID, taskId));
  }

  public Query add(Query query) {
    this.add(query.getCondition());
    return this;
  }

  public Query add(Condition condition) {
    if (condition == null) return this;

    if (aggCondition == null) {
      aggCondition = and(condition);
    } else {
      aggCondition.add(condition);
    }
    return this;
  }

  public Condition getCondition() {
    return this.aggCondition;
  }

  public List<OrderBy> getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(List<OrderBy> orderBy) {
    this.orderBy = orderBy;
  }
}
