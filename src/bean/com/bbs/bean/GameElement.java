package com.bbs.bean;

import java.io.Serializable;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbs.daoImpl.GEManagerDaoImpl;
@Component("gameElement") @Scope("prototype")
public class GameElement implements Serializable{
       private int id;
       private String name;
       private String media;
       private String events;
       private String strategy;
       private String video;
       private String pageEncoding;
       private Set<Board> boards;
       private String backStyle;
       private String logo;
       private Admin adminFK;
       private int version;
    public GameElement setPrototype(GameElement gE){
    	Admin admin = null;
    	if(gE.getAdminFK()!=null){
    		admin = new Admin(gE.getAdminFK().getAdminId(),gE.getAdminFK().getAdminAccount(),gE.getAdminFK().getAdminName(),"",gE.getAdminFK().getAdminLastTime(),gE.getAdminFK().getVersion());
    	}
    	this.id = gE.getId();
    	this.version = gE.getVersion();
    	this.events = gE.getEvents();
    	this.backStyle = gE.getBackStyle();
    	this.adminFK = admin;
    	this.logo = gE.getLogo();
    	this.media = gE.getMedia();
    	this.name = gE.getName();
    	this.pageEncoding = gE.getPageEncoding();
    	this.strategy = gE.getStrategy();
    	this.video = gE.getVideo();
    	return this;
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getPageEncoding() {
		return pageEncoding;
	}
	public void setPageEncoding(String pageEncoding) {
		this.pageEncoding = pageEncoding;
	}
	public Set<Board> getBoards() {
		return boards;
	}
	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}
	public String getBackStyle() {
		return backStyle;
	}
	public void setBackStyle(String backStyle) {
		this.backStyle = backStyle;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Admin getAdminFK() {
		return adminFK;
	}
	public void setAdminFK(Admin adminFK) {
		this.adminFK = adminFK;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
