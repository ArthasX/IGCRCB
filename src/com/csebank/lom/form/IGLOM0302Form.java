/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * Ԥ֧���ù���Form
 *
 */
public class IGLOM0302Form extends BaseForm implements AdvanCescostSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	protected String acdate_from;
	
	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	protected String acdate_to;
	
	/** Ԥ֧����ɾ������ */
	protected String[] deleteAcid;
	
	/**
	 * Ԥ֧����״̬
	 */
	protected String acstatus_q;

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼȡ��
	 * @return Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	public String getAcdate_from() {
		return acdate_from;
	}

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ�趨
	 * @param acdate_from Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	public void setAcdate_from(String acdate_from) {
		this.acdate_from = acdate_from;
	}

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�����ȡ��
	 * @return Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	public String getAcdate_to() {
		return acdate_to;
	}

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ������趨
	 * @param acdate_to Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	public void setAcdate_to(String acdate_to) {
		this.acdate_to = acdate_to;
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
	 * Ԥ֧����״̬ȡ��
	 * @return Ԥ֧����״̬
	 */
	public String getAcstatus_q() {
		return acstatus_q;
	}

	/**
	 * Ԥ֧����״̬�趨
	 * @param acstatus_q Ԥ֧����״̬
	 */
	public void setAcstatus_q(String acstatus_q) {
		this.acstatus_q = acstatus_q;
	}

}
