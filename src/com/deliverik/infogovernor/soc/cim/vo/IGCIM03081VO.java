/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * ����: �豸��ϸ��Ϣ��������֣�
 * ��������: �豸��ϸ��Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03081VO extends BaseVO implements Serializable{
	
	/**
	 * @param soc0124List
	 * @param entityItemVWInfoMap
	 */
	public IGCIM03081VO(List<SOC0124Info> soc0124List,
			Map<String, List<SOC0123Info>> entityItemVWInfoMap) {
		super();
		this.soc0124List = soc0124List;
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}

	/** �豸��Ϣ������� */
	protected List<SOC0124Info> soc0124List;
	
	/** ��Ӱ����豸��Ϣ */
	protected Map<String,List<SOC0123Info>> entityItemVWInfoMap;
	




	/**
	 * @param soc0124List
	 * @param entityItemVWInfoMap
	 */
	public IGCIM03081VO() {
		super();
	}

	/**
	 * ��Ӱ����豸��Ϣȡ��
	 * @return entityItemVWInfoMap��Ӱ����豸��Ϣ
	 */
	public Map<String, List<SOC0123Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * ��Ӱ����豸��Ϣ�趨
	 * @param entityItemVWInfoMap��Ӱ����豸��Ϣ
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<SOC0123Info>> entityItemVWInfoMap) {
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}

	/**
	 * �豸��Ϣ�������ȡ��
	 *
	 * @return soc0124List �豸��Ϣ�������
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * �豸��Ϣ��������趨
	 *
	 * @param soc0124List �豸��Ϣ�������
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}
	
}
