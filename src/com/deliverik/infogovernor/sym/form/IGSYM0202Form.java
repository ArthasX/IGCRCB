/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_�����޸�FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0202Form extends BaseForm implements User{
	
	
	/**
	 * �û�ID����¼ϵͳʱ�ã�
	 */
	
	private String loginType;//��¼��ʽ  NORMAL/LDAP
	
	
	/**
	 * �û�ID����¼ϵͳʱ�ã�
	 */
	
	protected String userid;
	
	
	/**
	 * �û���������ID
	 */
	
	protected String orgid;
	
	/**
	 * ����id
	 */
	
	protected String orgidstr;
	
	/**
	 * �û�������ʵ������
	 */
	
	protected String username;
	
	/**
	 * ������������
	 */
	
	protected String orgname;
	
	/**
	 * �û�˵��
	 */
	
	protected String userdesc;

	/**
	 * �û���Ϣ�������ֶΣ�
	 */
	
	protected String userinfo;

	/**
	 * �û�����
	 */
	
	protected String password;
	
	/**
	 * �û�����ȷ��
	 */
	
	protected String repassword;

	/**
	 * �û�״̬
	 */
	
	protected String userstatus;

	/**
	 * �û����ͣ������ֶΣ�
	 */
	
	protected String usertype;

	/**
	 * �û��绰
	 */
	
	protected String userphone;

	/**
	 * �û��ֻ�
	 */
	
	protected String usermobile;
	
	/**
	 * �û�����
	 */
	
	protected String useremail;
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	
	protected String mode = "0";
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	
	protected String userrolename;	
	
	/**
	 * ������
	 */
	
	protected String[] rolemanager;
	/**
	 * ������
	 */
	
	protected String[] rolemobile;
	/**
	 * ������
	 */
	
	protected String[] mobile;
	/**
	 * ������
	 */
	
	protected String[] roleid;
	
	/** �߼�ɾ����־λ */
	protected String deleteflag;


	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUserrolename() {
		return userrolename;
	}

	public void setUserrolename(String userrolename) {
		this.userrolename = userrolename;
	}

	/**
	 * ��ȡ�û�ID����¼ϵͳʱ�ã�
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û�ID����¼ϵͳʱ�ã�
	 * @param userid String
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ�û�������ʵ������
	 * @return String
	 */
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * �����û�������ʵ������
	 * @param username String
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * ��ȡ�û�˵��
	 * @return String
	 */
	
	public String getUserdesc() {
		return userdesc;
	}

	/**
	 * �����û�˵��
	 * @param userdesc String
	 */
	
	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}


	/**
	 * ��ȡ�û���Ϣ�������ֶΣ�
	 * @return String
	 */
	
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * �����û���Ϣ�������ֶΣ�
	 * @param userinfo String
	 */
	
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * ��ȡ�û�����
	 * @return String
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * �����û�����
	 * @param password String
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ��ȡ�û�״̬
	 * @return String
	 */
	
	public String getUserstatus() {
		return userstatus;
	}

	/**
	 * �����û�״̬
	 * @param userstatus String
	 */
	
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	/**
	 * ��ȡ�û����ͣ������ֶΣ�
	 * @return String
	 */
	
	public String getUsertype() {
		return usertype;
	}

	/**
	 * �����û����ͣ������ֶΣ�
	 * @param usertype String
	 */
	
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * ��ȡ�û��绰
	 * @return String
	 */
	
	public String getUserphone() {
		return userphone;
	}

	/**
	 * �����û��绰
	 * @param userphone String
	 */
	
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	/**
	 * ��ȡ�û��ֻ�
	 * @return String
	 */
	
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * �����û��ֻ�
	 * @param usermobile String
	 */
	
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * ��ȡ�û�����
	 * @return String
	 */
	
	public String getUseremail() {
		return useremail;
	}

	/**
	 * �����û�����
	 * @param useremail String
	 */
	
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * ��ȡҳ�������ʾ��־
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * ����ҳ�������ʾ��־
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ��ȡ����id
	 * @return String
	 */
	
	public String getOrgid() {
		if( (this.orgidstr == null) || ("".equals(this.orgidstr))){
			return null;
		} else {
			return this.orgidstr;
		}
	}
	
	/**
	 * �����û���������ID
	 * @param orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��ȡ����id
	 * @return String
	 */
	
	public String getOrgidstr() {
		return orgidstr;
	}
	
	/**
	 * ���û���id
	 * @param orgid String
	 */
	
	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}

	/**
	 * ����������������
	 * @param orgid String
	 */
	
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ��ȡ������������
	 * @return String
	 */
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();
		errors = super.validate(mapping, request);
		
		boolean flag = true;
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		loginType = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_AUTHORIZATIONTYPE);
		String localuser = "";//���ص�½�û���
		User nowUser = (User)request.getSession().getAttribute(BaseAction.SESSION_KEY_LOGIN_USER);
		String userid = nowUser.getUserid();

		localuser = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_LOCALORIZATIONTYPE);
		for(int i=0,j=localuser.split(",").length;i<j;i++){//�жϵ�ǰ�û��Ƿ�Ϊ���ص�½�û�������û�,�ǵĻ��Ͳ�ʹ��LDAP��֤
			String localUserId =  localuser.split(",")[i];
			if(null!=localUserId && userid.equals(localUserId)){
				flag = false;
			}
		}
		
		if("1".equals(loginType) && flag){
			
		}else{//��ͨ��¼��ʽ��ҪУ������
			if ( password != null ) {
				if (password.length()>16) {
					errors.add(Globals.ERROR_KEY, new ActionMessage("errors.invalid","�û����볤�Ȳ��ܳ���16λ��"));
				}
			}
		}
		
		
		return errors;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String[] getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(String[] rolemanager) {
		this.rolemanager = rolemanager;
	}

	public String[] getRolemobile() {
		return rolemobile;
	}

	public void setRolemobile(String[] rolemobile) {
		this.rolemobile = rolemobile;
	}

	public String[] getMobile() {
		return mobile;
	}

	public void setMobile(String[] mobile) {
		this.mobile = mobile;
	}

	public String[] getRoleid() {
		return roleid;
	}

	public void setRoleid(String[] roleid) {
		this.roleid = roleid;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Organization getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

}
