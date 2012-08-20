package com.bbs.service;

import java.util.List;

import com.bbs.bean.GameElement;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;

public interface IGEManagerService {
    public boolean addGamaElement(GameElement gE) throws ServiceException ;
    public GameElement getGEById(int gEId) throws ServiceException;
    public ResultHelper getAllGE(int pageSize) throws ServiceException;
    public ResultHelper getGEOnlyOne(int pageSize)throws Exception;
    public ResultHelper getGEByType(String by,String param,int pageSize) throws ServiceException;
    public void updateGE(GameElement gE) throws ServiceException;
    public void deleteGE(int gameId) throws ServiceException;
    public List getAllGEMap() throws ServiceException;
}
