package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * �����¼��¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM14021VO extends BaseVO implements Serializable{
	
	/** �����¼��¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData�������¼��¼����Ϣ
	 */
	public IGASM14021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * �����¼��¼����Ϣȡ��
	 * @return �����¼��¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


