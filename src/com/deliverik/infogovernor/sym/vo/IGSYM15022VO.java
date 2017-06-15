package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * �ʲ�������Ϣ��������֣�
 * 
 * @author
 *
 */
public class IGSYM15022VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 3346185553296597230L;

	/** ���ݷ�����Ϣ */
	CodeCategoryDefInfo codeCategoryDefInfo;
	
	/** ������ϸ��Ϣ */
	protected CodeDetailDef codeDetailDef;

	/**
	 * ���캯��
	 * @param codeCategoryInfo�����ݷ�����Ϣ
	 * @param codeDetail��������ϸ��Ϣ
	 */
	public IGSYM15022VO(CodeCategoryDefInfo codeCategoryDefInfo,CodeDetailDef codeDetailDef ) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
		this.codeDetailDef = codeDetailDef;
	}
	
	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}
	
	/**
	 * ������ϸ��Ϣȡ��
	 * @return ������ϸ��Ϣ
	 */
	public CodeDetailDef getCodeDetailDef() {
		return codeDetailDef;
	}
}


