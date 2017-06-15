package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * �ĵ���¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM05021VO extends BaseVO implements Serializable{
	
	/** �ĵ���¼����Ϣ */
	protected SOC0118Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData���ĵ���¼����Ϣ
	 */
	public IGASM05021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * �ĵ���¼����Ϣȡ��
	 * @return �ĵ���¼����Ϣ
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


