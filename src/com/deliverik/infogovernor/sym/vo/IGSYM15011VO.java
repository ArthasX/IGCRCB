package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;

/**
 * ���ݷ����б���Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM15011VO extends BaseVO implements Serializable{
	
	/** ���ݷ����б���Ϣ������� */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;

	/**
	 * ���캯��
	 * @param entityData�����ݷ����б���Ϣ�������
	 */
	public IGSYM15011VO(List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	
	/**
	 * ���ݷ����б���Ϣ�������ȡ��
	 * @return ���ݷ����б���Ϣ�������
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}

}


