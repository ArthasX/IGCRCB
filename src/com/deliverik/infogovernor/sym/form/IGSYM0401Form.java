/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��Ȩ��ѯForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0401Form extends BaseForm implements UserSearchCond{
	
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
	 * �û�����
	 */
	
	protected String username_q;
	
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
	
	/** �߼�ɾ����־λ */
	protected String deleteflag;
	
	
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

	public String getUserinfo() {
		// TODO Auto-generated method stub
		return null;
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
