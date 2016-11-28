package net.wyun.qys.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import net.wyun.qys.dao.StandardHandler;
import net.wyun.qys.domain.standard.Standard;
import net.wyun.qys.domain.standard.StandardType;

public class StandardDAOImpl extends CommonJPADAO<Standard, Long> implements StandardHandler {

	  private static final Logger LOG = Logger.getLogger("StandardDAOImpl");

	  public StandardDAOImpl() {
	  }

	  
	  public Standard update(Standard entity) {
	    return cloneEntity(super.update(entity));
	  }


	@Override
	public Standard save(Standard p) {
		return super.create(p);
	}


	@Override
	public Standard findById(String uuid) {
		// TODO Auto-generated method stub
		return super.getEntityManager().find(Standard.class, uuid);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Standard> findByTypes(Set<StandardType> types) {
		if(types.isEmpty()){
			//select all
			return this.findAll();
			
		}
		
		List<Integer> li = new ArrayList<Integer>();
		List<Standard> lst = new ArrayList<Standard>();
		
		for(StandardType st:types){
			li.add(st.getValue());
			/*
			List<Standard> l = this.getEntityManager().createNamedQuery("FROM Standard s " + 
			                                                            "WHERE " + 
					                                                    "s.type = :stype")
					                                   .setParameter("stype", st)
					                                   .getResultList();
			lst.addAll(l);
			*/
		}
		//return lst;
		
		final String paraQuery = "From Standard qs WHERE qs.type in :selected";
		return (List<Standard>) getEntityManager().createQuery(paraQuery)
				.setParameter("selected", types)
				.getResultList();
				
		
	}
	  
	  
}
