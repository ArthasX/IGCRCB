package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.sym.form.IGSYM1101Form;
import com.deliverik.infogovernor.sym.form.IGSYM1102Form;
import com.deliverik.infogovernor.sym.form.IGSYM1104Form;
import com.deliverik.infogovernor.sym.form.IGSYM1106Form;
import com.deliverik.infogovernor.sym.form.IGSYM1109Form;
import com.deliverik.infogovernor.sym.model.Priority;


/**
 * �������ݹ���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM11DTO extends BaseDTO implements Serializable {
	
	/** ���ݷ�����Ϣ������� */
	protected List<CodeCategoryInfo> codeCategoryInfoList;
	
	/** ���ݷ����б���Form */
	protected IGSYM1101Form igsym1101Form;

	/** ���ݷ�����Ϣ�༭����Form */
	protected IGSYM1102Form igsym1102Form;

	/** ������ϸ��Ϣ����Form */
	protected IGSYM1106Form igsym1106Form;
	
	/** ���ݷ�����Ϣ */
	protected CodeCategoryInfo codeCategoryInfo;

	/** ������ϸ��Ϣ��������� */
	protected List<CodeDetail> codeDetailList;
	
	/** ������ϸ��Ϣ */
	protected CodeDetail codeDetail;
	
	/** ���ȼ�List */
	protected List<Priority> prioritieList;
	
	/** ������� */
	protected String pprtype;
	
	public List<Priority> getPrioritieList() {
		return prioritieList;
	}

	public void setPrioritieList(List<Priority> prioritieList) {
		this.prioritieList = prioritieList;
	}

	public String getPprtype() {
		return pprtype;
	}

	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}

	public String getIvalue() {
		return ivalue;
	}

	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}

	public String getUvalue() {
		return uvalue;
	}

	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}

	/** Ӱ��� */
	protected String ivalue;
	
	/** ������ */
	protected String uvalue;
	
	//	
	/** ������ϸ��Ϣ�༭����FORM */
	protected IGSYM1104Form igsym1104Form;
	
	/** �������ȼ����û���Form */
	protected IGSYM1109Form igsym1109Form;
	
	/** �����̶� */
	protected List<CodeDetail> prurgencyList;
	
	/** Ӱ��̶� */
	protected List<CodeDetail> primpactList;
	
	
	
	
	
	public IGSYM1101Form getIgsym1101Form() {
		return igsym1101Form;
	}

	public void setIgsym1101Form(IGSYM1101Form igsym1101Form) {
		this.igsym1101Form = igsym1101Form;
	}

	/**
	 * ���ݷ�����Ϣ�������ȡ��
	 * @return ���������Ϣ�������
	 */
	public List<CodeCategoryInfo> getCodeCategoryInfoList() {
		return codeCategoryInfoList;
	}

	/**
	 * ���ݷ�����Ϣ��������趨
	 *
	 * @param codeCategoryInfoList ���ݷ�����Ϣ�������
	 */
	public void setCodeCategoryInfoList(
			List<CodeCategoryInfo> codeCategoryInfoList) {
		this.codeCategoryInfoList = codeCategoryInfoList;
	}
	/**
	 * ���ݷ�����Ϣ�༭����Formȡ��
	 * @return ���ݷ�����Ϣ�༭����Form
	 */
	public IGSYM1102Form getIgsym1102Form() {
		return igsym1102Form;
	}

	/**
	 * ���ݷ�����Ϣ�༭����Form�趨
	 *
	 * @param igsym1102Form ���ݷ�����Ϣ�༭����Form
	 */
	public void setIgsym1102Form(IGSYM1102Form igsym1102Form) {
		this.igsym1102Form = igsym1102Form;
	}

	/**
	 * ������ϸ��Ϣ����Formȡ��
	 * @return ������ϸ��Ϣ����Form
	 */
	public IGSYM1106Form getIgsym1106Form() {
		return igsym1106Form;
	}

	/**
	 * ������ϸ��Ϣ����Form�趨
	 *
	 * @param igsym1106Form ������ϸ��Ϣ����Form
	 */
	public void setIgsym1106Form(IGSYM1106Form igsym1106Form) {
		this.igsym1106Form = igsym1106Form;
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
	 * ������ϸ��Ϣȡ��
	 * @return ������ϸ��Ϣ
	 */
	public CodeDetail getCodeDetail() {
		return codeDetail;
	}

	/**
	 * ������ϸ��Ϣ�趨
	 *
	 * @param codeDetail ������ϸ��Ϣ
	 */
	public void setCodeDetail(CodeDetail codeDetail) {
		this.codeDetail = codeDetail;
	}

	/**
	 * ������ϸ��Ϣ�༭����FORMȡ��
	 * @return ������ϸ��Ϣ�༭����FORM
	 */
	public IGSYM1104Form getIgsym1104Form() {
		return igsym1104Form;
	}

	/**
	 * ������ϸ��Ϣ�༭����FORM�趨
	 *
	 * @param igsym1104Form ������ϸ��Ϣ�༭����FORM
	 */
	public void setIgsym1104Form(IGSYM1104Form igsym1104Form) {
		this.igsym1104Form = igsym1104Form;
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

	public IGSYM1109Form getIgsym1109Form() {
		return igsym1109Form;
	}

	public void setIgsym1109Form(IGSYM1109Form igsym1109Form) {
		this.igsym1109Form = igsym1109Form;
	}
	
	public List<CodeDetail> getPrurgencyList() {
		return prurgencyList;
	}

	public void setPrurgencyList(List<CodeDetail> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}

	public List<CodeDetail> getPrimpactList() {
		return primpactList;
	}

	public void setPrimpactList(List<CodeDetail> primpactList) {
		this.primpactList = primpactList;
	}


}
