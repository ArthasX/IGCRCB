/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.RoleSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_�˵���Ȩ��ѯForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0414Form extends BaseForm implements RoleSearchCond{
	
	/**
	 * ��ɫ����
	 */
	
	protected String roleid;
	
	/**
	 * ��ɫ����
	 */
	
	protected String rolename;
	
	/**
	 * ��ɫ���ƣ���ѯ��
	 */
	
	protected String rolename_q;
	
	/**
	 * ��ɫ����
	 */
	
	protected String roletype;
	/**
	 * ��ɫ�����Ƿ���ͬ
	 */
	protected int roletypeEqual;
	
	protected String roledomain;//��ɫ������
	
	/**
	 * �ʲ��������ݣ�esyscoding��
	 */
	protected String assetdomain;
	
	/** ��ɫ���Ͳ�ѯ��������ɫ���ʹ��ڣ�*/
	protected String roletype_gt;
	
	
	/**
	 * ��ɫ���Ͳ�ѯ����ȡ��
	 * @return ��ɫ���Ͳ�ѯ����
	 */
	public String getRoletype_gt() {
		return roletype_gt;
	}

	/**
	 * ��ɫ���Ͳ�ѯ�����趨
	 *
	 * @param roletype_gt ��ɫ���Ͳ�ѯ����
	 */
	public void setRoletype_gt(String roletype_gt) {
		this.roletype_gt = roletype_gt;
	}
	
	public String getAssetdomain() {
		return assetdomain;
	}

	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	public String getRoledomain() {
		return roledomain;
	}

	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * ��ȡ��ɫ����
	 * @return String
	 */
	
	public String getRoleid() {
		return roleid;
	}
	
	/**
	 * ���ý�ɫ����
	 * @param roleid String
	 */
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ��ȡ��ɫ����
	 * @return String
	 */
	
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * ���ý�ɫ����
	 * @param rolename String
	 */
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��ȡ��ɫ���ͣ�
	 * @return String
	 */
	
	public String getRoletype() {
		return roletype;
	}

	/**
	 * ���ý�ɫ����
	 * @param roletype String
	 */
	
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	/**
	 * ��ȡ��ɫ���ƣ���ѯ��
	 * @return String
	 */
	
	public String getRolename_q() {
		return rolename_q;
	}
	
	/**
	 * ���ý�ɫ���ƣ���ѯ��
	 * @param rolename_q String
	 */
	
	public void setRolename_q(String rolename_q) {
		this.rolename_q = rolename_q;
	}

	public int getRoletypeEqual() {
		return roletypeEqual;
	}

	public void setRoletypeEqual(int roletypeEqual) {
		this.roletypeEqual = roletypeEqual;
	}

	public String[] getRoles_BP_EX() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoles_Like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoledomain_Like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAssetdomain_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String pdid;


	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public List<Integer> getRoleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoleid_not_in() {
		// TODO Auto-generated method stub
		return null;
	}
}
