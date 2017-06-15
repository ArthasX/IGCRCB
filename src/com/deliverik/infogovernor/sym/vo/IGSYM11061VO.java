package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;

/**
 * �ʲ�������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM11061VO extends BaseVO implements Serializable{
	
	/** ���ݷ�����Ϣ */
	CodeCategoryInfo codeCategoryInfo;
	
	/** ������ϸ��Ϣ���� */
	protected List<CodeDetail> codeDetailList;
	
	/** ������ϸ��Ϣ */
	protected CodeDetail codeDetail;

	/**
	 * ���캯��
	 * @param codeCategoryInfo�����ݷ�����Ϣ
	 * @param codeDetailList��������ϸ��Ϣ����
	 * @param codeDetail��������ϸ��Ϣ
	 */
	public IGSYM11061VO(CodeCategoryInfo codeCategoryInfo,
			List<CodeDetail> codeDetailList,CodeDetail codeDetail ) {
		this.codeCategoryInfo = codeCategoryInfo;
		this.codeDetailList = codeDetailList;
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
	 * ������ϸ��Ϣ����ȡ��
	 * @return ������ϸ��Ϣ����
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}
	
	/**
	 * ������ϸ��Ϣȡ��
	 * @return ������ϸ��Ϣ
	 */
	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
}


