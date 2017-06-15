package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

public class IGASM03151VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** �豸��Ϣ������� */
	protected SOC0124Info entityItemVWInfo;
	
	/** Ȩ�� */
	protected Boolean flag;

	/**
	 * ���캯��
	 * @param entityData���豸��Ϣ�������
	 * @param flag��Ȩ��
	 */
	public IGASM03151VO(SOC0124Info entityItemVWInfo,Boolean flag) {
		this.entityItemVWInfo = entityItemVWInfo;
		this.flag = flag;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}
	
	public Boolean getFlag() {
		return flag;
	}
}