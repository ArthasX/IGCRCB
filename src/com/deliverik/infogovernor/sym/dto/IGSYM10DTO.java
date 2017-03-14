package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.sym.form.IGSYM1001Form;
import com.deliverik.infogovernor.sym.form.IGSYM1004Form;
import com.deliverik.infogovernor.sym.form.IGSYM1006Form;

/**
 * �������ݹ���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM10DTO extends BaseDTO implements Serializable {
	
	/** ���ݷ�����Ϣ������� */
	protected List<CodeCategoryInfo> codeCategoryList;
	
	/** ���ݷ����б���Form */
	protected IGSYM1001Form igsym1001Form;

	/** ������ϸ��Ϣ����Form */
	protected IGSYM1006Form igsym1006Form;

	/** ���ݷ�����Ϣ */
	protected CodeCategoryInfo codeCategoryInfo;

	/** ������ϸ��Ϣ��������� */
	protected List<CodeDetail> codeDetailList;
	
	/** ������ϸ��Ϣ�༭����FORM */
	protected IGSYM1004Form igsym1004Form;

	/** ������ϸ��Ϣ������Ϣ */
	protected boolean error = false;
	
	protected String flag; 
	/**
	 * ���ݷ����б���Formȡ��
	 * @return ���ݷ����б���Form
	 */
	public IGSYM1001Form getIgsym1001Form() {
		return igsym1001Form;
	}

	/**
	 * ���ݷ����б���Form�趨
	 *
	 * @param igsym1001Form ���ݷ����б���
	 */
	public void setIgsym1001Form(IGSYM1001Form igsym1001Form) {
		this.igsym1001Form = igsym1001Form;
	}
	
	/**
	 * ������ϸ��Ϣ����Formȡ��
	 * @return ������ϸ��Ϣ����Form
	 */
	public IGSYM1006Form getIgsym1006Form() {
		return igsym1006Form;
	}

	/**
	 * ������ϸ��Ϣ����Form�趨
	 *
	 * @param igsym1006Form ������ϸ��Ϣ����Form
	 */
	public void setIgsym1006Form(IGSYM1006Form igsym1006Form) {
		this.igsym1006Form = igsym1006Form;
	}

	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryInfo getCodeCategoryInfo() {
		return codeCategoryInfo;
	}

	/**
	 * ���ݷ�����Ϣ�趨
	 *
	 * @param codeCategoryInfo ���ݷ�����Ϣ
	 */
	public void setCodeCategoryInfo(CodeCategoryInfo codeCategoryInfo) {
		this.codeCategoryInfo = codeCategoryInfo;
	}

	/**
	 * ������ϸ��Ϣ���������ȡ��
	 * @return ������ϸ��Ϣ���������
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * ������ϸ��Ϣ����������趨
	 *
	 * @param codeDetailList ������ϸ��Ϣ���������
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/**
	 * ������ϸ��Ϣ�༭����FORMȡ��
	 * @return ������ϸ��Ϣ�༭����FORM
	 */
	public IGSYM1004Form getIgsym1004Form() {
		return igsym1004Form;
	}

	/**
	 * ������ϸ��Ϣ�༭����FORM�趨
	 *
	 * @param igsym1004Form ������ϸ��Ϣ�༭����FORM
	 */
	public void setIgsym1004Form(IGSYM1004Form igsym1004Form) {
		this.igsym1004Form = igsym1004Form;
	}
	
	/**
	 * �����ѯ������¼��
	 */
	private int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	private PagingDTO pagingDto;

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<CodeCategoryInfo> getCodeCategoryList() {
		return codeCategoryList;
	}

	public void setCodeCategoryList(List<CodeCategoryInfo> codeCategoryList) {
		this.codeCategoryList = codeCategoryList;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
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
