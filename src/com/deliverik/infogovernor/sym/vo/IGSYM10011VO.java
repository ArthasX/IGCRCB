package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;

/**
 * ���ݷ����б���Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM10011VO extends BaseVO implements Serializable{
	
	/** ���ݷ�����Ϣ������� */
	protected List<CodeCategoryInfo> entityDataList;

	/**
	 * ���캯��
	 * @param entityData�����ݷ����б���Ϣ�������
	 */
	public IGSYM10011VO(List<CodeCategoryInfo> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ���ݷ����б���Ϣ�������ȡ��
	 * @return ���ݷ����б���Ϣ�������
	 */
	public List<CodeCategoryInfo> getEntityDataList() {
		return entityDataList;
	}

}


