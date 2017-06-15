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
public class IGSYM10061VO extends BaseVO implements Serializable{
	
	/** ���ݷ�����Ϣ */
	CodeCategoryInfo codeCategoryInfo;
	
	/** ������ϸ��Ϣ */
	protected List<CodeDetail> codeDetailList;

	protected String flag;
	/**
	 * ���캯��
	 * @param codeCategoryInfo�����ݷ�����Ϣ
	 * @param codeDetailList��������ϸ��Ϣ
	 */
	public IGSYM10061VO(CodeCategoryInfo codeCategoryInfo,
			List<CodeDetail> codeDetailList) {
		this.codeCategoryInfo = codeCategoryInfo;
		this.codeDetailList = codeDetailList;
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
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}


