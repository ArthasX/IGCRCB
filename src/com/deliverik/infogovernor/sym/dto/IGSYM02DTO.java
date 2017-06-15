/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.infogovernor.sym.form.IGSYM0202Form;
import com.deliverik.infogovernor.sym.form.IGSYM0204Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGSYM02DTO extends BaseDTO implements Serializable {
	
	/**
	 * �û�����
	 */
	
	protected User user;
	/**
	 * �û���ѯBean
	 */
	
	protected UserSearchCond userSearchCond;
	
	/**
	 * �û�����List
	 */
	
	protected List<User> userList;

	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * �û�ɾ������
	 */
	
	protected String userid;
	
	/**
	 * ������û�������Ϣ
	 */
	
	protected IGSYM0202Form igsym0202Form;

	/** ��Ա��ѯ��Ϣ  */
	protected IGSYM0204Form igsym0204Form;
	
	
	/**
	 * �����б�
	 */
	
	protected List<Organization> organizationList;
	
	/**
	 * ��ɫid
	 */
	
	protected Integer roleid;
	
	/** �û���ҳ�б� */
	protected List<LabelValueBean> lst_LabelValueBean;

	/**
	 * ��ȡ�û�����
	 * @return User
	 */
	
	public User getUser() {
		return user;
	}

	/**
	 * �����û�����
	 * @param user User
	 */
	
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��ȡ�û���ѯBean
	 * @return UserSearchCond
	 */
	
	public UserSearchCond getUserSearchCond() {
		return userSearchCond;
	}

	/**
	 * �����û���ѯBean
	 * @param userSearchCond UserSearchCond
	 */
	
	public void setUserSearchCond(
			UserSearchCond userSearchCond) {
		this.userSearchCond = userSearchCond;
	}

	/**
	 * ��ȡ�û�����List
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * �����û�����List
	 * @param userList List<User>
	 */
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ȡ�û�ɾ������
	 * @return String
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û�ɾ������
	 * @param userid String
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ������û�������Ϣ
	 * @return IGSYM0202Form
	 */
	
	public IGSYM0202Form getIgsym0202Form() {
		return igsym0202Form;
	}

	/**
	 * ���ñ�����û�������Ϣ
	 * @param igsym0202Form IGSYM0202Form
	 */
	
	public void setIgsym0202Form(IGSYM0202Form igsym0202Form) {
		this.igsym0202Form = igsym0202Form;
	}

	/**
	 * ��ȡ�����б�
	 * @return List<Organization>
	 */
	
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * ���û����б�
	 * @param organizationList List<Organization>
	 */
	
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	/**
	 * ��ȡ��ɫid
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���ý�ɫid
	 * @param roleid Integer
	 */
	
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * �û���ҳ�б�ȡ��
	 * 
	 * @return �û���ҳ�б�
	 */
	public List<LabelValueBean> getLst_LabelValueBean() {
		return lst_LabelValueBean;
	}

	/**
	 * �û���ҳ�б��趨
	 * 
	 * @param lst_LabelValueBean �û���ҳ�б�
	 */
	public void setLst_LabelValueBean(List<LabelValueBean> lst_LabelValueBean) {
		this.lst_LabelValueBean = lst_LabelValueBean;
	}

	/**
	 * ��Ա��ѯ��Ϣȡ��
	 * @return igsym0204Form  ��Ա��ѯ��Ϣ
	 */
	public IGSYM0204Form getIgsym0204Form() {
		return igsym0204Form;
	}

	/**
	 * ��Ա��ѯ��Ϣ�趨
	 * @param igsym0204Form  ��Ա��ѯ��Ϣ
	 */
	public void setIgsym0204Form(IGSYM0204Form igsym0204Form) {
		this.igsym0204Form = igsym0204Form;
	}
	
}
