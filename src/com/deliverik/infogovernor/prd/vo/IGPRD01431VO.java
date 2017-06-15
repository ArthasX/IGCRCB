/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG299Info;

/**
 * ����: ����״̬�ɷ��ɻ�������VO
 * ��������: ����״̬�ɷ��ɻ�������VO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 2013/02/25		130225	���̻�������޸�(״̬�ɷ��ɻ�������)
 */
@SuppressWarnings("serial")
public class IGPRD01431VO extends BaseVO implements Serializable {

	/** ��ѡ�����б� */
	protected List<Organization> lst_Org;
	
	/** ��ѡ�����б�  */
	protected List<IG299Info> lst_ProcessStatusOrgDef;

	/**
	 * ��ѡ�����б�ȡ��
	 *
	 * @return lst_Org ��ѡ�����б�
	 */
	public List<Organization> getLst_Org() {
		return lst_Org;
	}

	/**
	 * ��ѡ�����б��趨
	 *
	 * @param lst_Org ��ѡ�����б�
	 */
	public void setLst_Org(List<Organization> lst_Org) {
		this.lst_Org = lst_Org;
	}

	/**
	 * ��ѡ�����б�ȡ��
	 *
	 * @return lst_ProcessStatusOrgDef ��ѡ�����б�
	 */
	public List<IG299Info> getLst_ProcessStatusOrgDef() {
		return lst_ProcessStatusOrgDef;
	}

	/**
	 * ��ѡ�����б��趨
	 *
	 * @param lst_ProcessStatusOrgDef ��ѡ�����б�
	 */
	public void setLst_ProcessStatusOrgDef(List<IG299Info> lst_ProcessStatusOrgDef) {
		this.lst_ProcessStatusOrgDef = lst_ProcessStatusOrgDef;
	}

	
}
