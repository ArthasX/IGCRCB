package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * ϵͳ��¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM18021VO extends BaseVO implements Serializable{
	
	/** ϵͳ��¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData��ϵͳ��¼����Ϣ
	 */
	public IGASM18021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ϵͳ��¼����Ϣȡ��
	 * @return ϵͳ��¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


