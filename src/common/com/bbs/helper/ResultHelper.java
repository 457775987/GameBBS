package com.bbs.helper;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("helper") @Scope("prototype")
public class ResultHelper {
       List list = null;
       private int maxPage = 0;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
