package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * �����¼��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM14011VO extends BaseVO implements Serializable{
	
	/** �����¼��Ϣ������� */
	protected List<SOC0124Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData�������¼��Ϣ�������
	 */
	public IGASM14011VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �����¼��Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


