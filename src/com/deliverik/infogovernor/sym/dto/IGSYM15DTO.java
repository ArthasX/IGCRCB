package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.infogovernor.sym.form.IGSYM1501Form;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.form.IGSYM1503Form;
import com.deliverik.infogovernor.sym.form.IGSYM1507Form;
import com.deliverik.infogovernor.sym.form.IGSYM1508Form;

/**
 * �������ݹ���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM15DTO extends BaseDTO implements Serializable {
	
	/** ���ݷ�����Ϣ������� */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;
	
	/** ���ݷ����б���Form */
	protected IGSYM1508Form igsym1508Form;

	/** ���ݷ�����Ϣ�༭����Form */
	protected IGSYM1507Form igsym1507Form;

	/** ������ϸ��Ϣ����Form */
	protected IGSYM1502Form igsym1502Form;

	/** ���ݷ�����Ϣ */
	protected CodeCategoryDefInfo codeCategoryDefInfo;

	/** ������ϸ��Ϣ��������� */
	protected List<CodeDetailDef> codeDetailDefList;
	
	/** ������ϸ��Ϣ */
	protected CodeDetailDef codeDetailDef;
//	
	/** ������ϸ��Ϣ�༭����FORM */
	protected IGSYM1503Form igsym1503Form;
	
	/** ���ݶ����б���Form */
	protected IGSYM1501Form igsym1501Form;
	
//	public IGSYM1101Form getIgsym1101Form() {
//		return igsym1101Form;
//	}
//
//	public void setIgsym1101Form(IGSYM1101Form igsym1101Form) {
//		this.igsym1101Form = igsym1101Form;
//	}

	/**
	 * ���ݷ�����Ϣ�������ȡ��
	 * @return ���������Ϣ�������
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}

	/**
	 * ���ݷ�����Ϣ��������趨
	 *
	 * @param codeCategoryDefInfoList ���ݷ�����Ϣ�������
	 */
	public void setCodeCategoryDefInfoList(
			List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	/**
	 * ���ݷ�����Ϣ�༭����Formȡ��
	 * @return ���ݷ�����Ϣ�༭����Form
	 */
	public IGSYM1507Form getIgsym1507Form() {
		return igsym1507Form;
	}

	/**
	 * ���ݷ�����Ϣ�༭����Form�趨
	 *
	 * @param igsym1507Form ���ݷ�����Ϣ�༭����Form
	 */
	public void setIgsym1507Form(IGSYM1507Form igsym1507Form) {
		this.igsym1507Form = igsym1507Form;
	}

	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}

	/**
	 * ���ݷ�����Ϣ�趨
	 *
	 * @param codeCategoryDefInfo ���ݷ�����Ϣ
	 */
	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}

	/**
	 * ������ϸ��Ϣ���������ȡ��
	 * @return ������ϸ��Ϣ���������
	 */
	public List<CodeDetailDef> getCodeDetailDefList() {
		return codeDetailDefList;
	}
	
	/**
	 * ������ϸ��Ϣ����������趨
	 *
	 * @param codeDetailDefList ������ϸ��Ϣ���������
	 */
	public void setCodeDetailDefList(List<CodeDetailDef> codeDetailDefList) {
		this.codeDetailDefList = codeDetailDefList;
	}
	
	/**
	 * ������ϸ��Ϣȡ��
	 * @return ������ϸ��Ϣ
	 */
	public CodeDetailDef getCodeDetailDef() {
		return codeDetailDef;
	}

	/**
	 * ������ϸ��Ϣ�趨
	 *
	 * @param codeDetailDef ������ϸ��Ϣ
	 */
	public void setCodeDetailDef(CodeDetailDef codeDetailDef) {
		this.codeDetailDef = codeDetailDef;
	}

//	/**
//	 * ������ϸ��Ϣ�༭����FORMȡ��
//	 * @return ������ϸ��Ϣ�༭����FORM
//	 */
//	public IGSYM1503Form getIgsym1104Form() {
//		return igsym1104Form;
//	}
//
//	/**
//	 * ������ϸ��Ϣ�༭����FORM�趨
//	 *
//	 * @param igsym1104Form ������ϸ��Ϣ�༭����FORM
//	 */
//	public void setIGSYM1503Form(IGSYM1503Form igsym1104Form) {
//		this.igsym1104Form = igsym1104Form;
//	}
	
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

	public IGSYM1501Form getIgsym1501Form() {
		return igsym1501Form;
	}

	public void setIgsym1501Form(IGSYM1501Form igsym1501Form) {
		this.igsym1501Form = igsym1501Form;
	}

	public IGSYM1502Form getIgsym1106Form() {
		return igsym1502Form;
	}

	public void setIgsym1502Form(IGSYM1502Form igsym1502Form) {
		this.igsym1502Form = igsym1502Form;
	}

	public IGSYM1503Form getIgsym1503Form() {
		return igsym1503Form;
	}

	public void setIgsym1503Form(IGSYM1503Form igsym1503Form) {
		this.igsym1503Form = igsym1503Form;
	}

	/**
	 * @return the igsym1508Form
	 */
	public IGSYM1508Form getIgsym1508Form() {
		return igsym1508Form;
	}

	/**
	 * @param igsym1508Form the igsym1508Form to set
	 */
	public void setIgsym1508Form(IGSYM1508Form igsym1508Form) {
		this.igsym1508Form = igsym1508Form;
	}

	/**
	 * @return the igsym1502Form
	 */
	public IGSYM1502Form getIgsym1502Form() {
		return igsym1502Form;
	}
	
}
