package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * �ʲ�������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM15021VO extends BaseVO implements Serializable{
	
	/** ���ݷ�����Ϣ */
	CodeCategoryDefInfo codeCategoryDefInfo;
	
	/** ������ϸ��Ϣ���� */
	protected List<CodeDetailDef> codeDetailList;
	
	/** ������ϸ��Ϣ */
	protected CodeDetailDef codeDetail;

	/**
	 * ���캯��
	 * @param codeCategoryDefInfo�����ݷ�����Ϣ
	 * @param codeDetailList��������ϸ��Ϣ����
	 * @param codeDetail��������ϸ��Ϣ
	 */
	public IGSYM15021VO(CodeCategoryDefInfo codeCategoryDefInfo,
			List<CodeDetailDef> codeDetailList,CodeDetailDef codeDetail ) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
		this.codeDetailList = codeDetailList;
		this.codeDetail = codeDetail;
	}
	
	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
//	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
//		return codeCategoryDefInfo;
//	}

	/**
	 * ������ϸ��Ϣ����ȡ��
	 * @return ������ϸ��Ϣ����
	 */
	public List<CodeDetailDef> getCodeDetailList() {
		return codeDetailList;
	}
	
	/**
	 * ������ϸ��Ϣȡ��
	 * @return ������ϸ��Ϣ
	 */
	public CodeDetailDef getCodeDetail() {
		return codeDetail;
	}

	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}

	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}

	public void setCodeDetailList(List<CodeDetailDef> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	public void setCodeDetail(CodeDetailDef codeDetail) {
		this.codeDetail = codeDetail;
	}
}


