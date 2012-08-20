package com.bbs.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.bean.GameElement;
import com.bbs.dao.IGEManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IGEManagerService;
@Service("gEService") @Scope("prototype") @Transactional
public class GEManagerServiceImpl implements IGEManagerService {
	@Resource(name="gEDao") IGEManagerDao gEDao = null;
	@Resource SessionFactory sessionFactory = null;
    @Resource ResultHelper helper = null;
    @Resource List<GameElement> list = null;
	public boolean addGamaElement(GameElement gE) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
		            boolean boo=gEDao.addGamaElement(gE, session);
					return boo;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("新增主题失败！");
				}
	}
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getAllGE(int pageSize) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					List<Object> gEs = gEDao.getAllGE(pageSize, session);
					helper.setList(gEs);
					helper.setMaxPage(gEDao.getAllGECount(session));
					return helper;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("查询所有主题失败！");
				}
	}
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public GameElement getGEById(int gEId) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					GameElement gEs = gEDao.getGEById(gEId, session);
					gEs.setBoards(null);
					return gEs;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("查询主题失败！");
				}
	}
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getGEByType(String by, String param, int pageSize)
			throws ServiceException {
				try{
					System.out.println("getGEByType");
					Session session = sessionFactory.getCurrentSession();
					List<GameElement> gEs= gEDao.getGEByType(by, param, pageSize, session);
					helper.setList(gEs);
					helper.setMaxPage(gEDao.getAllGECount(session));
					return helper;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("条件查找主题失败！");
				}
	}

	public void deleteGE(int gameId) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					GameElement game = gEDao.getGEById(gameId, session);
					gEDao.deleteGE(game, session);
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("删除主题失败!");
				}
	}

	public void updateGE(GameElement gE) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();	
		            gEDao.updateGE(gE, session);
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("更新主题失败!");
				}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getGEOnlyOne(int pageSize) throws Exception {
				try{
					Session session = sessionFactory.getCurrentSession();
		            GameElement game = gEDao.getGEOnlyOne(pageSize, session);
		            list.add(game);
		            helper.setMaxPage(gEDao.getAllGECount(session));
		            helper.setList(list);
					return helper;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("查询失败！");
				}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List getAllGEMap() throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
		            List games = gEDao.getAllGEMap(session);
					return games;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("");
				}
	}

}
