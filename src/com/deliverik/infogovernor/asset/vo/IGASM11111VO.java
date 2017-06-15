package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * ������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11111VO extends BaseVO implements Serializable{
	
	/** ������Ϣ������� */
	protected List<SOC0603Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData��������Ϣ�������
	 */
	public IGASM11111VO(List<SOC0603Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ������Ϣ�������ȡ��
	 * @return ������Ϣ�������
	 */
	public List<SOC0603Info> getEntityDataList() {
		return entityDataList;
	}

}


