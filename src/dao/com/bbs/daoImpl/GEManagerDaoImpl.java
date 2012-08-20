package com.bbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.GameElement;
import com.bbs.dao.IGEManagerDao;
import com.bbs.file.PropertiesFileRead;
@Repository("gEDao")
public class GEManagerDaoImpl implements IGEManagerDao {
	@Resource(name="proFileRead") PropertiesFileRead pro = null;
	public boolean addGamaElement(GameElement gE,Session session) throws Exception {
		return (Integer)session.save(gE)>0?true:false;
	}

	public List<Object> getAllGE(int pageSize, Session session)
			throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		return session.createQuery("select a.id,a.name,b.adminName from GameElement as a,Admin as b where a.adminFK.adminId=b.adminId")
		.setMaxResults(size)
		.setFirstResult(size*pageSize).list();
	}
	
	public GameElement getGEOnlyOne(int pageSize, Session session)
	throws Exception {
		int size = Integer.parseInt(pro.getValue("gamePageSize"));
		return (GameElement)session.createQuery("from GameElement")
		.setMaxResults(size)
		.setFirstResult(size*pageSize).uniqueResult();
	}

	public GameElement getGEById(int gEId, Session session) throws Exception {
		return (GameElement)session.get(GameElement.class, gEId);
	}

	public int getAllGECount(Session session) throws Exception {
		return (Integer)session.createCriteria(GameElement.class).setProjection(Projections.rowCount())
		   .uniqueResult();
	}

	public List<GameElement> getGEByType(String by, String param, int pageSize,
			Session session) throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		return session.createCriteria(GameElement.class).add(Restrictions.like(by, "%"+param+"%"))
		.setFirstResult(size*pageSize).setMaxResults(size).list();
	}

	public void updateGE(GameElement gE, Session session) throws Exception {
		session.update(gE);
	}

	public void deleteGE(GameElement gE, Session session) throws Exception {
		session.delete(gE);
	}

	public List getAllGEMap(Session session) throws Exception {
		return session.createQuery("select new map(id as id,name as name) from GameElement").list();
	}

}
