package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ��Ʊ��¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM24021VO extends BaseVO implements Serializable{
	
	/** ��Ʊ��¼����Ϣ */
	protected IG013Info entityItemData;
	
	/**
	 * ���캯��
	 * @param entityData����Ʊ��¼����Ϣ
	 */
	public IGASM24021VO(IG013Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ��Ʊ��¼����Ϣȡ��
	 * @return ��Ʊ��¼����Ϣ
	 */
	public IG013Info getEntityData() {
		return entityItemData;
	}
}


