package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;

/**
 * �ʲ�������Ϣ��������֣�
 * 
 * @author
 *
 */
public class IGSYM11062VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 3346185553296597230L;

	/** ���ݷ�����Ϣ */
	CodeCategoryInfo codeCategoryInfo;
	
	/** ������ϸ��Ϣ */
	protected CodeDetail codeDetail;

	/**
	 * ���캯��
	 * @param codeCategoryInfo�����ݷ�����Ϣ
	 * @param codeDetail��������ϸ��Ϣ
	 */
	public IGSYM11062VO(CodeCategoryInfo codeCategoryInfo,CodeDetail codeDetail ) {
		this.codeCategoryInfo = codeCategoryInfo;
		this.codeDetail = codeDetail;
	}
	
	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryInfo getCodeCategoryInfo() {
		return codeCategoryInfo;
	}
	
	/**
	 * ������ϸ��Ϣȡ��
	 * @return ������ϸ��Ϣ
	 */
	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
}


