package com.bbs.userAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Role;

import com.bbs.bean.Admin;
import com.bbs.bean.User;
import com.bbs.exception.ServiceException;
import com.bbs.file.FileUploadType;
import com.bbs.service.IUserManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class UserRegister extends ActionSupport implements ModelDriven<User> {
	@Resource(name="user") private User user = null;
	@Resource private IUserManagerService service = null;
	@Resource private Role role = null;
	@Resource(name="dateFormat") private SimpleDateFormat dateFormat = null;
	@Resource(name="fileDateName") private SimpleDateFormat fileDateName = null;
	private int roleId = 0;
	private String rePassword;
	private String oldHead;
	private File head;//�ļ��ϴ�
	private String headFileName;//�ϴ��ļ���
	private String headContentType;//�ϴ��ļ�����
	private String regTime;
    private String page;


	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public File getHead() {
		return head;
	}

	public void setHead(File head) {
		this.head = head;
	}

	public String getHeadFileName() {
		return headFileName;
	}

	public void setHeadFileName(String headFileName) {
		this.headFileName = headFileName;
	}

	public String getHeadContentType() {
		return headContentType;
	}

	public void setHeadContentType(String headContentType) {
		this.headContentType = headContentType;
	}

	public String getOldHead() {
		return oldHead;
	}

	public void setOldHead(String oldHead) {
		this.oldHead = oldHead;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
    @Override
    public void validate() {
    	try{
    	if(!rePassword.equals(user.getUserPassword())){
    		this.addActionError("�����������벻ƥ�䣡");
    	}
    	if(headFileName!=null){
        	if(FileUploadType.IMAGE_Type.split(headContentType).length!=2){
        		this.addActionError("�ļ��ϴ������ʹ����������ͣ�"+FileUploadType.IMAGE_Type);
        	}
        	String headName = user.getUserName()+"@"+fileDateName.format(new Date())+
        	getHeadFileName().substring(getHeadFileName().lastIndexOf("."),getHeadFileName().length());
        	user.setUserHead(headName);
        	fileUpload(headName);
    	}else{
    		user.setUserHead(oldHead);
    	}
    	user.setUserLastTime(dateFormat.parse(dateFormat.format(new Date())));
    	user.setUserUpdateDate(user.getUserLastTime());
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
	@Override
    public String execute() throws Exception {
		try{
			user.setUserRegTime(dateFormat.parse(dateFormat.format(new Date())));
    	if(service.addUser(user)){
    		if(page!=null && page.equals("userInfo_manage")){
    			return "userInfo_manage";
    		}
    		return SUCCESS;
    	}
		}catch(ServiceException ex){
			ex.printStackTrace();
			this.addActionError("ע��ʧ�ܣ��û����ظ���"+ex.getErrorMsg());
		}catch(Exception ex){
			this.addActionError("ע��ʧ�ܣ������û����ظ���");
		}
    	return INPUT;
    }
	
	public void validateUpdateUserExecute(){
		Admin currentAdmin = (Admin)ServletActionContext.getRequest().getSession().getAttribute("currentAdmin");
		User currentUser = (User)ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		if(currentAdmin==null && (currentUser.getUserId()!=user.getUserId())){
			this.addActionError("�Ƿ��������벻Ҫ��ͼ�޸�������Ϣ");
		}
	}
	
    public String updateUserExecute() throws Exception{
    	try{
    		user.setUserRegTime(dateFormat.parse(regTime));
    		role.setRoleId(roleId);
    		user.setUserRoleFK(role);
        	service.updateUserById(user);
    		}catch(ServiceException ex){
    			ex.printStackTrace();
    			this.addActionError("������Ϣ��"+ex.getErrorMsg());
    			return INPUT;
    		}
    		if(page!=null && page.equals("userInfo_manage")){
    			return "userInfo_manage";
    		}
    		return "index";
    }
    
	public User getModel() {
		return user;
	}
	public void fileUpload(String headName){
		FileInputStream input = null;
    	FileOutputStream output = null;
    	try{
    	String headPath = ServletActionContext.getServletContext().getRealPath("/head");
    	input = new FileInputStream(getHead());
    	output = new FileOutputStream(new File(headPath+"\\"+headName));
    	byte[] by = new byte[1024];
    	int index = -1 ;
    	while((index=input.read(by))!=-1){
    		output.write(by, 0, index);
    	}
    	}catch(Exception ex){
    		ex.printStackTrace();
    		this.addActionError("ͷ���ϴ�ʧ�ܣ�");
    	}finally{
    		try{
    		input.close();
    		output.close();
    		}catch(Exception ex){ex.printStackTrace();}
    	}
	}
}
