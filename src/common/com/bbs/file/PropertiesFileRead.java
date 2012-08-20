package com.bbs.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("proFileRead") @Scope("singleton")
public class PropertiesFileRead {
	   @Resource private Properties pro = null;
	   @Resource private InputStream proInput = null;
       public String getValue(String key) throws IOException{
   	          pro.load(proInput);
    	      return pro.getProperty(key);
       }
}
