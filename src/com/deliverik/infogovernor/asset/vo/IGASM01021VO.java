package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * �ʲ����͵�¼����Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM01021VO extends BaseVO implements Serializable{
	
	/** �ʲ����͵�¼����Ϣ */
	protected SOC0117Info entityData;
	
	/**
	 * ���캯��
	 * @param entityData���ʲ����͵�¼����Ϣ
	 */
	public IGASM01021VO(SOC0117Info entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * �ʲ����͵�¼����Ϣȡ��
	 * @return �ʲ����͵�¼����Ϣ
	 */
	public SOC0117Info getEntityData() {
		return entityData;
	}

}


