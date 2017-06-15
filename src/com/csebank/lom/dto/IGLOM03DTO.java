/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.form.IGLOM0301Form;
import com.csebank.lom.form.IGLOM0303Form;
import com.csebank.lom.form.IGLOM0304Form;
import com.csebank.lom.form.IGLOM0306Form;
import com.csebank.lom.form.IGLOM0307Form;
import com.csebank.lom.form.IGLOM0309Form;
import com.csebank.lom.form.IGLOM0313Form;
import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * Ԥ֧���ù���DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM03DTO extends BaseDTO implements Serializable {
	

	/** Ԥ֧���ù����ѯ���� */
	protected AdvanCescostSearchCond advanCescostSearchCond;
	
	/** ���������ȷ����ѯ���� */
	protected LoanPayDetailSearchCond loanPayDetailSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** Ԥ֧������Ϣ���������� */
	protected int maxSearchCount;
	
	/** Ԥ֧������ϢForm */
	protected IGLOM0301Form iglom0301Form;
	
	/** �����ϢForm */
	protected IGLOM0303Form iglom0303Form;
	
	/** ���������ȷ��Form */
	protected IGLOM0304Form iglom0304Form;
	
	/** ����Form */
	protected IGLOM0306Form iglom0306Form;
	
	/** ��ּƲƲ����Form */
	protected IGLOM0307Form iglom0307Form;
	
	/** ����Ǽ�Form */
	protected IGLOM0313Form iglom0313Form;
	
	/** Ԥ֧���� */
	protected AdvanCescost advanCescost;
	
	/** Ԥ֧������������� */
	protected List<AdvanCescost> advanCescostList;
	
	/** Ԥ֧����ɾ������ */
	protected String[] deleteAcid;
	
	/** �軹�� */
	protected LoanPayDetail loanPayDetail;
	
	/** �軹����������� */
	protected List<LoanPayDetail> loanPayDetailList;
	
	/** �����Ϣ */
	protected LoanPayDetail loanPayDetailData;
	
	/** ���ɾ������ */
	protected String[] deleteLpdid;
	
	/** �����ܶ� */
	protected BigDecimal[] db;
	
	/** �û�ID */
	protected String userid;
	
	/** �û����� */
	protected String username;
	
	/** Ԥ֧��Աͳ�Ʋ�ѯ�ӿ� */
	protected PersonLoanSummarySearchCond personLoanSummarySearchCond;
	
	/** Ԥ֧��Աͳ�Ʋ�ѯ����б� */
	protected List<PersonLoanSummary> personLoanSummaryList;
	
	/** ��Ա�����ϸ��ѯ�ӿ� */
	protected PersonLoanDetailSearchCond personLoanDetailSearchCond;
	
	/** ��Ա�����ϸ��ѯ����б� */
	protected List<PersonLoanDetail> personLoanDetailList;
	
	/** Ԥ֧��ϸ��ѯ�ӿ� */
	protected AdvanceDetailSearchCond advanceDetailSearchCond;
	
	/** Ԥ֧��ϸ��ѯ����б� */
	protected List<AdvanceDetail> advanceDetailList;
	
	/** Ԥ֧�¶�ͳ��Form */
	protected IGLOM0309Form iglom0309Form;
	
	/** Ԥ֧�¶�ͳ�Ʋ�ѯ���� */
	protected AdvancesummaryCond advancesummaryCond;
	
	/** Ԥ֧�¶�ͳ�ƽ���� */
	protected List<AdvanceSummary> advanceSummarylList;
	
	/** ���ý�� */
	protected BigDecimal availableAmount;
	
	
	public List<AdvanceSummary> getAdvanceSummarylList() {
		return advanceSummarylList;
	}

	public void setAdvanceSummarylList(List<AdvanceSummary> advanceSummarylList) {
		this.advanceSummarylList = advanceSummarylList;
	}

	public AdvancesummaryCond getAdvancesummaryCond() {
		return advancesummaryCond;
	}

	public void setAdvancesummaryCond(AdvancesummaryCond advancesummaryCond) {
		this.advancesummaryCond = advancesummaryCond;
	}

	public IGLOM0309Form getIglom0309Form() {
		return iglom0309Form;
	}

	public void setIglom0309Form(IGLOM0309Form iglom0309Form) {
		this.iglom0309Form = iglom0309Form;
	}

	
	/**
	 * Ԥ֧���ù����ѯ����ȡ��
	 * @return Ԥ֧���ù����ѯ����
	 */
	public AdvanCescostSearchCond getAdvanCescostSearchCond() {
		return advanCescostSearchCond;
	}

	/**
	 * Ԥ֧���ù����ѯ�����趨
	 * @param advanCescostSearchCond Ԥ֧���ù����ѯ�����趨
	 */
	public void setAdvanCescostSearchCond(AdvanCescostSearchCond advanCescostSearchCond) {
		this.advanCescostSearchCond = advanCescostSearchCond;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * Ԥ֧������Ϣ����������ȡ��
	 * @return Ԥ֧������Ϣ����������ȡ��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * Ԥ֧������Ϣ�����������趨
	 * @param maxSearchCount Ԥ֧������Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * Ԥ֧������ϢFormȡ��
	 * @return Ԥ֧������ϢForm
	 */
	public IGLOM0301Form getIglom0301Form() {
		return iglom0301Form;
	}

	/**
	 * Ԥ֧������ϢForm�趨
	 * @param igLOM0301Form Ԥ֧������ϢForm
	 */
	public void setIglom0301Form(IGLOM0301Form iglom0301Form) {
		this.iglom0301Form = iglom0301Form;
	}

	/**
	 * Ԥ֧����ȡ��
	 * @return Ԥ֧����
	 */
	public AdvanCescost getAdvanCescost() {
		return advanCescost;
	}

	/**
	 * Ԥ֧�����趨
	 * @param advanCescost Ԥ֧����
	 */
	public void setAdvanCescost(AdvanCescost advanCescost) {
		this.advanCescost = advanCescost;
	}

	/**
	 * Ԥ֧�������������ȡ��
	 * @return Ԥ֧�������������
	 */
	public List<AdvanCescost> getAdvanCescostList() {
		return advanCescostList;
	}

	/**
	 * Ԥ֧��������������趨
	 * @param advanCescostList Ԥ֧�������������
	 */
	public void setAdvanCescostList(List<AdvanCescost> advanCescostList) {
		this.advanCescostList = advanCescostList;
	}

	/**
	 * Ԥ֧����ɾ������ȡ��
	 * @return Ԥ֧����ɾ������
	 */
	public String[] getDeleteAcid() {
		return deleteAcid;
	}

	/**
	 * Ԥ֧����ɾ�������趨
	 * @param deleteAcid Ԥ֧����ɾ������
	 */
	public void setDeleteAcid(String[] deleteAcid) {
		this.deleteAcid = deleteAcid;
	}

	/**
	 * �����ϢFormȡ��
	 * @return �����ϢForm
	 */
	public IGLOM0303Form getIglom0303Form() {
		return iglom0303Form;
	}

	/**
	 * �����ϢForm�趨
	 * @param iglom0303Form �����ϢForm
	 */
	public void setIglom0303Form(IGLOM0303Form iglom0303Form) {
		this.iglom0303Form = iglom0303Form;
	}

	/**
	 * ���ȡ��
	 * @return ���
	 */
	public LoanPayDetail getLoanPayDetail() {
		return loanPayDetail;
	}

	/**
	 * ����趨
	 * @param loanPayDetail ���
	 */
	public void setLoanPayDetail(LoanPayDetail loanPayDetail) {
		this.loanPayDetail = loanPayDetail;
	}

	/**
	 * ���������ȷ�����������ȡ��
	 * @return ���������ȷ�����������
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * ���������ȷ������������趨
	 * @param loanPayDetailList ���������ȷ�����������
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

	/**
	 * ���������ȷ����ѯ����ȡ��
	 * @return ���������ȷ����ѯ����
	 */
	public LoanPayDetailSearchCond getLoanPayDetailSearchCond() {
		return loanPayDetailSearchCond;
	}

	/**
	 * ���������ȷ����ѯ�����趨
	 * @param loanPayDetailSearchCond ���������ȷ����ѯ����
	 */
	public void setLoanPayDetailSearchCond(
			LoanPayDetailSearchCond loanPayDetailSearchCond) {
		this.loanPayDetailSearchCond = loanPayDetailSearchCond;
	}

	/**
	 * ���������ȷ��Formȡ��
	 * @return ���������ȷ��Form
	 */
	public IGLOM0304Form getIglom0304Form() {
		return iglom0304Form;
	}
	
	/**
	 * ���������ȷ��Form�趨
	 * @param iglom0304Form ���������ȷ��Form
	 */
	public void setIglom0304Form(IGLOM0304Form iglom0304Form) {
		this.iglom0304Form = iglom0304Form;
	}
	
	/**
	 * ��ּƲƲ����Formȡ��
	 * @return ��ּƲƲ����Form
	 */
	public IGLOM0307Form getIglom0307Form() {
		return iglom0307Form;
	}

	/**
	 * ��ּƲƲ����Form�趨
	 * @param iglom0307Form ��ּƲƲ����
	 */
	public void setIglom0307Form(IGLOM0307Form iglom0307Form) {
		this.iglom0307Form = iglom0307Form;
	}

	/**
	 * ���ɾ������ȡ��
	 * @return ���ɾ������
	 */
	public String[] getDeleteLpdid() {
		return deleteLpdid;
	}

	/**
	 * ���ɾ�������趨
	 * @param deleteLpdid ���ɾ������
	 */
	public void setDeleteLpdid(String[] deleteLpdid) {
		this.deleteLpdid = deleteLpdid;
	}

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �û������趨
	 * @param username �û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ����formȡ��
	 * @return ����form
	 */
	public IGLOM0306Form getIglom0306Form() {
		return iglom0306Form;
	}

	/**
	 * ����form�趨
	 * @param iglom0305Form ����form
	 */
	public void setIglom0306Form(IGLOM0306Form iglom0306Form) {
		this.iglom0306Form = iglom0306Form;
	}

	/**
	 * ����Ǽ�Formȡ��
	 * @return ����Ǽ�Form
	 */
	public IGLOM0313Form getIglom0313Form() {
		return iglom0313Form;
	}

	/**
	 * ����Ǽ�Form�趨
	 * @param iglom0313Form ����Ǽ�Form
	 */
	public void setIglom0313Form(IGLOM0313Form iglom0313Form) {
		this.iglom0313Form = iglom0313Form;
	}

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�ȡ��
	 * @return Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�
	 */
	public PersonLoanSummarySearchCond getPersonLoanSummarySearchCond() {
		return personLoanSummarySearchCond;
	}

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ��趨
	 * @param personLoanSummarySearchCond Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�
	 */
	public void setPersonLoanSummarySearchCond(
			PersonLoanSummarySearchCond personLoanSummarySearchCond) {
		this.personLoanSummarySearchCond = personLoanSummarySearchCond;
	}

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ����б�ȡ��
	 * @return Ԥ֧��Աͳ�Ʋ�ѯ����б�
	 */
	public List<PersonLoanSummary> getPersonLoanSummaryList() {
		return personLoanSummaryList;
	}

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯ����б��趨
	 * @param personLoanSummarySearchCond Ԥ֧��Աͳ�Ʋ�ѯ����б�
	 */
	public void setPersonLoanSummaryList(
			List<PersonLoanSummary> personLoanSummaryList) {
		this.personLoanSummaryList = personLoanSummaryList;
	}

	/**
	 * ��Ա�����ϸ��ѯ�ӿ�ȡ��
	 * @return ��Ա�����ϸ��ѯ�ӿ�
	 */
	public PersonLoanDetailSearchCond getPersonLoanDetailSearchCond() {
		return personLoanDetailSearchCond;
	}

	/**
	 * ��Ա�����ϸ��ѯ�ӿ��趨
	 * @param personLoanDetailSearchCond ��Ա�����ϸ��ѯ�ӿ�
	 */
	public void setPersonLoanDetailSearchCond(
			PersonLoanDetailSearchCond personLoanDetailSearchCond) {
		this.personLoanDetailSearchCond = personLoanDetailSearchCond;
	}

	/**
	 * ��Ա�����ϸ��ѯ����б�ȡ��
	 * @return ��Ա�����ϸ��ѯ����б�
	 */
	public List<PersonLoanDetail> getPersonLoanDetailList() {
		return personLoanDetailList;
	}

	/**
	 * ��Ա�����ϸ��ѯ����б��趨
	 * @param personLoanDetailList ��Ա�����ϸ��ѯ����б�
	 */
	public void setPersonLoanDetailList(List<PersonLoanDetail> personLoanDetailList) {
		this.personLoanDetailList = personLoanDetailList;
	}

	/**
	 * Ԥ֧��ϸ��ѯ�ӿ�ȡ��
	 * @return Ԥ֧��ϸ��ѯ�ӿ�
	 */
	public AdvanceDetailSearchCond getAdvanceDetailSearchCond() {
		return advanceDetailSearchCond;
	}

	/**
	 * Ԥ֧��ϸ��ѯ�ӿ��趨
	 * @param advanceDetailSearchCond Ԥ֧��ϸ��ѯ�ӿ�
	 */
	public void setAdvanceDetailSearchCond(
			AdvanceDetailSearchCond advanceDetailSearchCond) {
		this.advanceDetailSearchCond = advanceDetailSearchCond;
	}

	/**
	 * Ԥ֧��ϸ��ѯ����б�ȡ��
	 * @return Ԥ֧��ϸ��ѯ����б�
	 */
	public List<AdvanceDetail> getAdvanceDetailList() {
		return advanceDetailList;
	}

	/**
	 * Ԥ֧��ϸ��ѯ����б��趨
	 * @param advanceDetailList Ԥ֧��ϸ��ѯ����б�
	 */
	public void setAdvanceDetailList(List<AdvanceDetail> advanceDetailList) {
		this.advanceDetailList = advanceDetailList;
	}

	/**
	 * �����Ϣȡ��
	 * @return �����Ϣ
	 */
	public LoanPayDetail getLoanPayDetailData() {
		return loanPayDetailData;
	}

	/**
	 * �����Ϣ�趨
	 * @param loanPayDetailData �����Ϣ
	 */
	public void setLoanPayDetailData(LoanPayDetail loanPayDetailData) {
		this.loanPayDetailData = loanPayDetailData;
	}

	/**
	 * �����ܶ�ȡ��
	 * @return �����ܶ�
	 */
	public BigDecimal[] getDb() {
		return db;
	}

	/**
	 * �����ܶ��趨
	 * @param db �����ܶ�
	 */
	public void setDb(BigDecimal[] db) {
		this.db = db;
	}

	/**
	 * ���ý��ȡ��
	 * @return ���ý��
	 */
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	/**
	 * ���ý���趨
	 * @param availableAmount ���ý��
	 */
	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	
}
