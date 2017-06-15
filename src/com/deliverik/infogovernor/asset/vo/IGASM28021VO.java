package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * ������¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM28021VO extends BaseVO implements Serializable{
	
	/** ������¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData��������¼����Ϣ
	 */
	public IGASM28021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ������¼����Ϣȡ��
	 * @return ������¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


