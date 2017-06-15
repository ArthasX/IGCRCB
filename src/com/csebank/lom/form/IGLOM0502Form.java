/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.condition.EaterySearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ʳ�óɱ�����Form
 *
 */
public class IGLOM0502Form extends BaseForm  implements EaterySearchCond {


	private static final long serialVersionUID = 1L;

	/** �������������� */
	protected Integer eid;
	
	/** ���� */
	protected String edate;
	
	/** �ɹ�ԭ�ϳɱ� */
	protected BigDecimal estaplecost;
	
	/** ��ζƷ�ɱ� */
	protected BigDecimal eflavouringcost;
	
	/** �����ɱ� */
	protected BigDecimal eothercost;
	
	/** ��¼�汾��ʶ */
	protected String fingerprint;
	
	/** ʳ�óɱ���Ϣ��ʼʱ�� */
	public String etime_from;
	
	/** ʳ�óɱ���Ϣ����ʱ�� */
	public String etime_to;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";	
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public Integer getEid() {
		return eid;
	}
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @return �ɹ�ԭ�ϳɱ�
	 */
	public BigDecimal getEstaplecost() {
		return estaplecost;
	}
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @return �ɹ�ԭ�ϳɱ�
	 */
	public void setEstaplecost(BigDecimal estaplecost) {
		this.estaplecost = estaplecost;
	}
	
	/**
	 * ��ζƷ�ɱ�
	 * @return ��ζƷ�ɱ�
	 */
	public BigDecimal getEflavouringcost() {
		return eflavouringcost;
	}
	
	/**
	 * ��ζƷ�ɱ�
	 * @return ��ζƷ�ɱ�
	 */
	public void setEflavouringcost(BigDecimal eflavouringcost) {
		this.eflavouringcost = eflavouringcost;
	}
	
	/**
	 * �����ɱ�
	 * @return �����ɱ�
	 */
	public BigDecimal getEothercost() {
		return eothercost;
	}
	
	/**
	 * �����ɱ�
	 * @return �����ɱ�
	 */
	public void setEothercost(BigDecimal eothercost) {
		this.eothercost = eothercost;
	}
	
	/**
	 * ��¼�汾��ʶ
	 * @return ��¼�汾��ʶ
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	
	/**
	 * ��¼�汾��ʶ
	 * @return ��¼�汾��ʶ
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ҳ�������ʾȡ��
	 * @return ҳ�������ʾ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ҳ�������ʾ�趨
	 * @param mode ҳ�������ʾ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ʳ�óɱ���Ϣʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * ʳ�óɱ���Ϣ��ʼʱ���ѯ�趨
	 * @param etime_from ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯ�趨
	 * @param etime_to ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}

}
