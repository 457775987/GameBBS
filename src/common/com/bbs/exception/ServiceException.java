package com.bbs.exception;

public class ServiceException extends Exception{
	   private String errorMsg = "´íÎó£¡";
       public ServiceException(String errorMsg){
    	   this.errorMsg = errorMsg; 
       }
       public String toString(){
    	   return this.errorMsg;
       }
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
