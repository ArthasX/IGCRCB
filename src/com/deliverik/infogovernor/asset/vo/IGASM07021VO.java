package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM07021VO extends BaseVO implements Serializable{
	
	/** ������¼����Ϣ */
	protected IG013Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData��������¼����Ϣ
	 */
	public IGASM07021VO(IG013Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ������¼����Ϣȡ��
	 * @return ������¼����Ϣ
	 */
	public IG013Info getEntityData() {
		return entityItemData;
	}
}


