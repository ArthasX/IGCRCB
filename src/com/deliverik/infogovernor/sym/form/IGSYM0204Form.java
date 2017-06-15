/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_��ѯɾ��Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0204Form extends BaseForm implements UserSearchCond{
	
	/**
	 * �û�����
	 */
	
	protected String userid;
	
	/**
	 * �û�id(��ѯ)
	 */
	
	protected String userid_q;
	
	/**
	 * �û�����
	 */
	
	protected String username;
	
	/**
	 * �û�����(��ѯ)
	 */
	
	protected String username_q;
	
	/**
	 * �û�ɾ������
	 */
	
	protected String[] deleteUserid;
	
	/**
	 * ����
	 */
	
	protected String password;
	
	/**
	 * ����id
	 */
	
	protected String orgid;
	
	/**
	 * ����id
	 */
	
	protected String orgidstr;
	/**
	 * ����name
	 */
	
	protected String orgname;
	
	protected String roleid;
	
	protected String pos;
	/** �߼�ɾ����־λ */
	protected String deleteflag;
	
	/**
	 * ����
	 * */
	protected String userinfo;
	
	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ��ȡ�û�����
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}
	
	/**
	 * �����û�����
	 * @param userid String
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * ��ȡ�û�����
	 * @return String
	 */
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * �����û�����
	 * @param username String
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡ�û�ɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteUserid() {
		return deleteUserid;
	}

	/**
	 * �����û�ɾ������
	 * @param deleteUserid String[]
	 */
	
	public void setDeleteUserid(String[] deleteUserid) {
		this.deleteUserid = deleteUserid;
	}
	
	/**
	 * ����Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.orgname = null;
		this.orgidstr = null;
	}

	/**
	 * ��ȡ����
	 * @return String
	 */
	
	public String getPassword() {
		return password;
	}

	/**
	 * ��������
	 * @param password String
	 */
	
	public void setPassword(String password) {
		this.password = password;
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
	 * ���û���id
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
	 * ��ȡ�û����ƣ���ѯ��
	 * @return String
	 */
	
	public String getUsername_q() {
		return username_q;
	}

	/**
	 * �����û����ƣ���ѯ��
	 * @param username_q String
	 */
	
	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	/**
	 * ��ȡ�û�id����ѯ��
	 * @return String
	 */
	
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * �����û�id����ѯ��
	 * @param userid_q String
	 */
	
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getUsermobile() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getUserinfo_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUserid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

}
