package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ����¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM02021VO extends BaseVO implements Serializable{
	
	/** �ʲ����¼����Ϣ */
	protected IG013Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData���ʲ����¼����Ϣ
	 */
	public IGASM02021VO(IG013Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * �ʲ����¼����Ϣȡ��
	 * @return �ʲ����¼����Ϣ
	 */
	public IG013Info getEntityData() {
		return entityItemData;
	}
}


