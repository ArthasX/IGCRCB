package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * ��Ա��ϵ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM19061VO extends BaseVO implements Serializable{
	
	/** �豸��Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	
	/** �ʲ����ϵ��Ϣ1���� */
	protected int parCount;
	
	/** �ʲ����ϵ��Ϣ2���� */
	protected int cldCount;

	/** ��Ա������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * ���캯��
	 * @param entityItemData���豸��Ϣ
	 * @param parEntityItemRelationMap���ʲ����ϵ��Ϣ1
	 * @param cldEntityItemRelationList���ʲ����ϵ��Ϣ2
	 * @param parCount���ʲ����ϵ��Ϣ1����
	 * @param cldCount���ʲ����ϵ��Ϣ2����
	 */
	public IGASM19061VO(SOC0124Info entityItemData,
			Map<String,List<SOC0119Info>> parEntityItemRelationMap,
			Map<String,List<SOC0119Info>> cldEntityItemRelationMap,
			int parCount,
			int cldCount) {
		this.entityItemData = entityItemData;
		this.parEntityItemRelationMap = parEntityItemRelationMap;
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
		this.parCount = parCount;
		this.cldCount = cldCount;
		
	}
	
	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param username �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2ȡ��
	 * @return �ʲ����ϵ������Ϣ�������2
	 */
	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2�趨
	 *
	 * @param cldEntityItemRelationMap �ʲ����ϵ������Ϣ�������2
	 */
	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ��Ϣ1����ȡ��
	 * @return �ʲ����ϵ��Ϣ1����
	 */
	public int getParCount() {
		return parCount;
	}

	/**
	 * �ʲ����ϵ��Ϣ2�����趨
	 *
	 * @param parCount �ʲ����ϵ��Ϣ2����
	 */
	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	/**
	 * �ʲ����ϵ��Ϣ1����ȡ��
	 * @return �ʲ����ϵ��Ϣ1����
	 */
	public int getCldCount() {
		return cldCount;
	}

	/**
	 * �ʲ����ϵ��Ϣ2�����趨
	 *
	 * @param cldCount �ʲ����ϵ��Ϣ2����
	 */
	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}
}


