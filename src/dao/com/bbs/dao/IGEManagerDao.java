package com.bbs.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.bbs.bean.GameElement;

public interface IGEManagerDao {
       public boolean addGamaElement(GameElement gE,Session session) throws Exception ;
       public GameElement getGEById(int gEId,Session session) throws Exception;
       public List<Object> getAllGE(int pageSize,Session session) throws Exception;
       public GameElement getGEOnlyOne(int pageSize, Session session)throws Exception;
       public int getAllGECount(Session session) throws Exception;
       public List<GameElement> getGEByType(String by,String param,int pageSize,Session session) throws Exception;
       public void updateGE(GameElement gE,Session session) throws Exception;
       public void deleteGE(GameElement gE,Session session) throws Exception;
       public List getAllGEMap(Session session) throws Exception;
}
