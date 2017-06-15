package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * �����¼��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM14141VO extends BaseVO implements Serializable{
	
	/** �����¼��Ϣ������� */
	protected List<SOC0118Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData�������¼��Ϣ�������
	 */
	public IGASM14141VO(List<SOC0118Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �����¼��Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0118Info> getEntityDataList() {
		return entityDataList;
	}

}


