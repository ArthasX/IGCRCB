/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG123Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:������Χѡ��vo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01311VO extends BaseVO{

	/** ��ѡ�������� */
	protected List<IG123Info> pordList;
	
	/** ��ѡ�������� */
	protected Map<Organization, List<Organization>> orgTreeMap;
	
	/**
	 * ��ѡ��������ȡ��
	 * @return ��ѡ��������
	 */
	public List<IG123Info> getPordList() {
		return pordList;
	}

	/**
	 * ��ѡ���������趨
	 * @param pordList ��ѡ��������
	 */
	public void setPordList(List<IG123Info> pordList) {
		this.pordList = pordList;
	}

	/**
	 * ��ѡ��������ȡ��
	 * @return ��ѡ��������
	 */
	public Map<Organization, List<Organization>> getOrgTreeMap() {
		return orgTreeMap;
	}

	/**
	 * ��ѡ���������趨
	 * @param orgTreeMap ��ѡ��������
	 */
	public void setOrgTreeMap(Map<Organization, List<Organization>> orgTreeMap) {
		this.orgTreeMap = orgTreeMap;
	}
}
