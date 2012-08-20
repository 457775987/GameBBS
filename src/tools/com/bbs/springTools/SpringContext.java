package com.bbs.springTools;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringContext {
       private static ClassPathXmlApplicationContext context = null;
       static{
    	   if(context==null){
    		   System.out.println("创建应用上下文，Spring开始扫描加载对象");
    	      context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	   }
       }
	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}
	public static Object getBean(String name){
		return context.getBean(name);
	}
}
