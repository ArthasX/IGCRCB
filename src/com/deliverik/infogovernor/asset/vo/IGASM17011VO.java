package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �����Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM17011VO extends BaseVO implements Serializable{
	
	/** �����Ϣ������� */
	protected List<IG688Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData�������Ϣ�������
	 */
	public IGASM17011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �����Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

}


