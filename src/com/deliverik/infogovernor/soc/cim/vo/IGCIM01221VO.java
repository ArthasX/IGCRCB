package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * Ӧ�õ�¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01221VO extends BaseVO implements Serializable{
	
	/** Ӧ�õ�¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData��Ӧ�õ�¼����Ϣ
	 */
	public IGCIM01221VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * Ӧ�õ�¼����Ϣȡ��
	 * @return Ӧ�õ�¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


