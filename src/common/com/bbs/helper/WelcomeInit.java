package com.bbs.helper;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbs.bean.GameElement;
import com.bbs.service.IGEManagerService;
import com.bbs.serviceImpl.GEManagerServiceImpl;
@Component("welcome") @Scope("prototype")
public class WelcomeInit {
       @Resource private IGEManagerService gEService = null;
       private int pageSize = 0;
       private int nowPage = 0;
       private int next = 0;
       private int before = 0;
       
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNext() {
		return this.next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getBefore() {
		return before;
	}

	public void setBefore(int before) {
		this.before = before;
	}
    
	public GameElement getGameElementOnlyOne(int nowPage) throws Exception{
		try{
		   ResultHelper helper = gEService.getGEOnlyOne(nowPage);
		   this.pageSize = helper.getMaxPage();
		   this.nowPage = nowPage;
		   this.next = nowPage+1;
		   this.before = nowPage-1;
		   if(this.nowPage==pageSize-1){
				next=0;
			}
			if(nowPage==0){
				before=pageSize-1;
			}
			System.out.println("size:"+helper.getList().size());
    	   return (GameElement)helper.getList().get(0);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
       }
}
