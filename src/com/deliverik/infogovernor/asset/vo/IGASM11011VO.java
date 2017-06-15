package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0601Info;

/**
 * ������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11011VO extends BaseVO implements Serializable{
	
	/** ������Ϣ������� */
	protected List<SOC0601Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData��������Ϣ�������
	 */
	public IGASM11011VO(List<SOC0601Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ������Ϣ�������ȡ��
	 * @return ������Ϣ�������
	 */
	public List<SOC0601Info> getEntityDataList() {
		return entityDataList;
	}

}


