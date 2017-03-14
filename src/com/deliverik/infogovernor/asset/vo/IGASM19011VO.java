package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * ��Ա��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM19011VO extends BaseVO implements Serializable{
	
	/** ��Ա��Ϣ������� */
	protected List<SOC0124Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData����Ա��Ϣ�������
	 */
	public IGASM19011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ��Ա��Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


