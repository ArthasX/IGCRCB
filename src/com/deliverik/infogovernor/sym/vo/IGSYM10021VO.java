package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;

/**
 * ���ݷ���ǼǴ���֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM10021VO extends BaseVO implements Serializable{
	
	/** ���ݷ�����Ϣ */
	protected CodeCategoryInfo entityData;

	/**
	 * ���캯��
	 * @param entityData�����ݷ�����Ϣ
	 */
	public IGSYM10021VO(CodeCategoryInfo entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryInfo getEntityData() {
		return entityData;
	}

}


