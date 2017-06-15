/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;

/**
 * <p>����:���̲����߶���ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG222Info  extends BaseModel {
	/**
	 * ���ܣ����̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getPpdid();
	
	/**
	 * ���ܣ�����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���ܣ����̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ���ܣ����̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getUserid();
	
	/**
	 * ����super�����߱�ʶȡ��
	 * @return ����super�����߱�ʶ
	 */
	public String getPpdsuper();
	
	/**
	 * ���ܣ���ɫȡ��
	 * @return ��ɫ
	 */
	public RoleTB getRole();
	
	/**
	 * ���ܣ��û�ȡ��
	 * @return �û�
	 */
	public UserTB getUser();
	
	public List<IG132TB> getProcessParticipantButtonDefList();
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getOrgid();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public OrganizationTB getOrg();
}
