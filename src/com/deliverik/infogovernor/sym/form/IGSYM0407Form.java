/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_��ɫ������Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0407Form extends BaseForm implements UserRoleVWSearchCond,UserRoleSearchCond {
	
	/** �û�ID */
	protected String userid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** ��ɫ���� */
	protected String roletype;
	
	/** ��ɫ����like��ѯ���� */
	protected String roles_Like;
	
	/** ���̽�ɫ��չ���� */
	protected String[] roles_BP_EX;
	
	/** ��ɫ�û�����ID */
	protected String[] urids;
	
	/** ��ʼ��ʱ�Ƿ��и����� */
	protected String hasManager;

	/** ��ʼ��ʱ�Ƿ���ֵ���� */
	protected String hasWatchManager;
	
	/**
	 * �û�IDȡ��
	 * 
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ɫIDȡ��
	 * 
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ɫ����ȡ��
	 * 
	 * @return ��ɫ����
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param roletype ��ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * ��ɫ����like��ѯ����ȡ��
	 * 
	 * @return ��ɫ����like��ѯ����
	 */
	public String getRoles_Like() {
		return roles_Like;
	}

	/**
	 * ��ɫ����like��ѯ�����趨
	 *
	 * @param roles_Like ��ɫ����like��ѯ����
	 */
	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	/**
	 * ���̽�ɫ��չ����ȡ��
	 * 
	 * @return ���̽�ɫ��չ����
	 */
	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	/**
	 * ���̽�ɫ��չ�����趨
	 *
	 * @param roles_BP_EX ���̽�ɫ��չ����
	 */
	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	/**
	 * ��ɫ�û�����IDȡ��
	 * 
	 * @return ��ɫ�û�����ID
	 */
	public String[] getUrids() {
		return urids;
	}

	/**
	 * ��ɫ�û�����ID�趨
	 *
	 * @param urids ��ɫ�û�����ID
	 */
	public void setUrids(String[] urids) {
		this.urids = urids;
	}

	/**
	 * ��ʼ��ʱ�Ƿ��и�����ȡ��
	 * 
	 * @return ��ʼ��ʱ�Ƿ��и�����
	 */
	public String getHasManager() {
		return hasManager;
	}

	/**
	 * ��ʼ��ʱ�Ƿ��и������趨
	 *
	 * @param hasManager ��ʼ��ʱ�Ƿ��и�����
	 */
	public void setHasManager(String hasManager) {
		this.hasManager = hasManager;
	}
	
	
	public String getHasWatchManager() {
		return hasWatchManager;
	}

	public void setHasWatchManager(String hasWatchManager) {
		this.hasWatchManager = hasWatchManager;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roles_BP_EX = null;
		this.urids = null;
	}

	public boolean isRolemanager() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDutyflag() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAssetdomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRolename_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUrid_eq(Integer urid_eq) {
		// TODO Auto-generated method stub
		
	}

	public String getUsername_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getRoleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

}
