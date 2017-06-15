package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;

/**
 * �豸��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11151VO extends BaseVO implements Serializable{
	
	/** �豸��Ϣ������� */
	protected List<SOC0602Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData���豸��Ϣ�������
	 */
	public IGASM11151VO(List<SOC0602Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �豸��Ϣ�������ȡ��
	 * @return �豸��Ϣ�������
	 */
	public List<SOC0602Info> getEntityDataList() {
		return entityDataList;
	}

}


