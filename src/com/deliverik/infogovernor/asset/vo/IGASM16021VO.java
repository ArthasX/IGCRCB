package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * ���ݵ�¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM16021VO extends BaseVO implements Serializable{
	
	/** ���ݵ�¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData�����ݵ�¼����Ϣ
	 */
	public IGASM16021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ���ݵ�¼����Ϣȡ��
	 * @return ���ݵ�¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


