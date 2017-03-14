package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * Ӧ����Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01571VO extends BaseVO implements Serializable{
	
	/** Ӧ����Ϣ������� */
	protected List<SOC0124Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData��Ӧ����Ϣ�������
	 */
	public IGCIM01571VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * Ӧ����Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


