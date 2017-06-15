package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
 * �������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM31011VO extends BaseVO implements Serializable{
	
	/** �������Ϣ������� */
	protected List<SOC0124Info> entityDataList;
	
	/**����ָ��--�Ƿ�ؼ�ָ������*/
	protected List<SOC0151Info> keyIndexList;
	
	/**����ָ��--��ֵ����*/
	protected List<SOC0151Info> thresholdList;
	
	/**����ָ���ѯ���ؼ���*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;

	/**
	 * ���캯��
	 * @param entityData���������Ϣ�������
	 */
	public IGASM31011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �������Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}
	/**
	 * ����ָ��--�Ƿ�ؼ�ָ������ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getKeyIndexList() {
		return keyIndexList;
	}
	/**
	 * ����ָ��--�Ƿ�ؼ�ָ�������趨
	 */
	public void setKeyIndexList(List<SOC0151Info> keyIndexList) {
		this.keyIndexList = keyIndexList;
	}
	
	/**
	 * ����ָ��--��ֵ����ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getThresholdList() {
		return thresholdList;
	}
	/**
	 * ����ָ��--��ֵ�����趨
	 */
	public void setThresholdList(List<SOC0151Info> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}

}


