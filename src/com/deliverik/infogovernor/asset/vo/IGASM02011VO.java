package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ�����Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM02011VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ϣ������� */
	protected List<IG688Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData���ʲ�����Ϣ�������
	 */
	public IGASM02011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �ʲ�����Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

}


