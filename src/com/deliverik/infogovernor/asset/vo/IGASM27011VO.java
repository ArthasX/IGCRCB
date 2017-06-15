package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * ���յ���Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM27011VO extends BaseVO implements Serializable{
	
	/** ���յ���Ϣ������� */
	protected List<SOC0124Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData�����յ���Ϣ�������
	 */
	public IGASM27011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ���յ���Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


