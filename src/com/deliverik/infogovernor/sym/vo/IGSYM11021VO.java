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
public class IGSYM11021VO extends BaseVO implements Serializable{
	
	/** ���ݷ�����Ϣ */
	protected CodeCategoryInfo codeCategoryInfo;

	/**
	 * ���캯��
	 * @param codeCategoryInfo�����ݷ�����Ϣ
	 */
	public IGSYM11021VO(CodeCategoryInfo codeCategoryInfo) {
		this.codeCategoryInfo = codeCategoryInfo;
	}
	
	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryInfo getCodeCategoryInfo() {
		return codeCategoryInfo;
	}

}


