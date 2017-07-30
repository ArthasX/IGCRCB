package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * ��Ա��¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM14021VO extends BaseVO implements Serializable{
	
	/** ��Ա��¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData����Ա��¼����Ϣ
	 */
	public IGCIM14021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ��Ա��¼����Ϣȡ��
	 * @return ��Ա��¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}

