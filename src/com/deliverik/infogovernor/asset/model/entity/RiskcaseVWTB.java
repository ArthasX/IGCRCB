/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;

/**
  * ����: �����¼�ʵ��
  * ��������: �����¼�ʵ��
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="riskcaseVW")
public class RiskcaseVWTB extends BaseEntity implements Serializable,
		Cloneable, RiskcaseVWInfo {

	/** �ʲ�ID */
	@Id
	protected Integer EIID;

	/** �����¼����� */
	protected String fcname;

	/** �����¼����� */
	protected String fcdesc;

	/** �����¼�״̬ */
	protected String EISTATUS;

	/** ���յ����� */
	protected String fcriskname;

	/** ���յ�ID  */
	protected String riskid;

	/** �����¼���Դ */
	protected String fcorigin;

	/** �����¼��������� */
	protected String fccategory;

	/** �����������ID  */
	protected String riskjobid;

	/** ���յ����ID */
	protected String risktype;

	/** �������ؼ������� */
	protected String fcseveritylevel;

	/** ���շ������������� */
	protected String fcpossibility;

	/** ���ռ������� */
	protected String fclevel;

	/** ����ʶ��ʱ�� */
	protected String riskcatchtime;

	/** Ӧ���������� */
	protected String fcrisktask;

	/** Ӧ���������� */
	protected String fcrisktaskdesc;

	/** Ӧ�Բ��� */
	protected String fcpolicy;

	/** Ӧ��Ŀ��  */
	protected String fcoperatoraim;

	/** Ӧ�Բ���ID */
	protected String riskoperatordept;

	/** Ӧ�Բ��� */
	protected String fcoperatordept;

	/** Ӧ�Ը�����ID */
	protected String riskoperator;

	/** Ӧ�Ը����� */
	protected String fcoperator;

	/** ���ͷ����ԱID */
	protected String riskccoperator;

	/** ���ͷ����Ա */
	protected String fcccoperator;

	/** ������ */
	protected String riskreviewresult;
	
	/** �����������ID */
	protected String riskdealid;
	
	/** �汾 */
	protected String version;

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEIID() {
		return EIID;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param EIID �ʲ�ID
	 */
	public void setEIID(Integer EIID) {
		this.EIID = EIID;
	}

	/**
	 * �����¼�����ȡ��
	 *
	 * @return �����¼�����
	 */
	public String getFcname() {
		return fcname;
	}

	/**
	 * �����¼������趨
	 *
	 * @param fcname �����¼�����
	 */
	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	/**
	 * �����¼�����ȡ��
	 *
	 * @return �����¼�����
	 */
	public String getFcdesc() {
		return fcdesc;
	}

	/**
	 * �����¼������趨
	 *
	 * @param fcdesc �����¼�����
	 */
	public void setFcdesc(String fcdesc) {
		this.fcdesc = fcdesc;
	}

	/**
	 * �����¼�״̬ȡ��
	 *
	 * @return �����¼�״̬
	 */
	public String getEISTATUS() {
		return EISTATUS;
	}

	/**
	 * �����¼�״̬�趨
	 *
	 * @param EISTATUS �����¼�״̬
	 */
	public void setEISTATUS(String EISTATUS) {
		this.EISTATUS = EISTATUS;
	}

	/**
	 * ���յ�����ȡ��
	 *
	 * @return ���յ�����
	 */
	public String getFcriskname() {
		return fcriskname;
	}

	/**
	 * ���յ������趨
	 *
	 * @param fcriskname ���յ�����
	 */
	public void setFcriskname(String fcriskname) {
		this.fcriskname = fcriskname;
	}

	/**
	 * ���յ�ID ȡ��
	 *
	 * @return ���յ�ID 
	 */
	public String getRiskid() {
		return riskid;
	}

	/**
	 * ���յ�ID �趨
	 *
	 * @param riskid ���յ�ID 
	 */
	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}

	/**
	 * �����¼���Դȡ��
	 *
	 * @return �����¼���Դ
	 */
	public String getFcorigin() {
		return fcorigin;
	}

	/**
	 * �����¼���Դ�趨
	 *
	 * @param fcorigin �����¼���Դ
	 */
	public void setFcorigin(String fcorigin) {
		this.fcorigin = fcorigin;
	}

	/**
	 * �����¼���������ȡ��
	 *
	 * @return �����¼���������
	 */
	public String getFccategory() {
		return fccategory;
	}

	/**
	 * �����¼����������趨
	 *
	 * @param fccategory �����¼���������
	 */
	public void setFccategory(String fccategory) {
		this.fccategory = fccategory;
	}

	/**
	 * �����������ID ȡ��
	 *
	 * @return �����������ID 
	 */
	public String getRiskjobid() {
		return riskjobid;
	}

	/**
	 * �����������ID �趨
	 *
	 * @param riskjobid �����������ID 
	 */
	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}

	/**
	 * ���յ����IDȡ��
	 *
	 * @return ���յ����ID
	 */
	public String getRisktype() {
		return risktype;
	}

	/**
	 * ���յ����ID�趨
	 *
	 * @param risktype ���յ����ID
	 */
	public void setRisktype(String risktype) {
		this.risktype = risktype;
	}

	/**
	 * �������ؼ�������ȡ��
	 *
	 * @return �������ؼ�������
	 */
	public String getFcseveritylevel() {
		return fcseveritylevel;
	}

	/**
	 * �������ؼ��������趨
	 *
	 * @param fcseveritylevel �������ؼ�������
	 */
	public void setFcseveritylevel(String fcseveritylevel) {
		this.fcseveritylevel = fcseveritylevel;
	}

	/**
	 * ���շ�������������ȡ��
	 *
	 * @return ���շ�������������
	 */
	public String getFcpossibility() {
		return fcpossibility;
	}

	/**
	 * ���շ��������������趨
	 *
	 * @param fcpossibility ���շ�������������
	 */
	public void setFcpossibility(String fcpossibility) {
		this.fcpossibility = fcpossibility;
	}

	/**
	 * ���ռ�������ȡ��
	 *
	 * @return ���ռ�������
	 */
	public String getFclevel() {
		return fclevel;
	}

	/**
	 * ���ռ��������趨
	 *
	 * @param fclevel ���ռ�������
	 */
	public void setFclevel(String fclevel) {
		this.fclevel = fclevel;
	}

	/**
	 * ����ʶ��ʱ��ȡ��
	 *
	 * @return ����ʶ��ʱ��
	 */
	public String getRiskcatchtime() {
		return riskcatchtime;
	}

	/**
	 * ����ʶ��ʱ���趨
	 *
	 * @param riskcatchtime ����ʶ��ʱ��
	 */
	public void setRiskcatchtime(String riskcatchtime) {
		this.riskcatchtime = riskcatchtime;
	}

	/**
	 * Ӧ����������ȡ��
	 *
	 * @return Ӧ����������
	 */
	public String getFcrisktask() {
		return fcrisktask;
	}

	/**
	 * Ӧ�����������趨
	 *
	 * @param fcrisktask Ӧ����������
	 */
	public void setFcrisktask(String fcrisktask) {
		this.fcrisktask = fcrisktask;
	}

	/**
	 * Ӧ����������ȡ��
	 *
	 * @return Ӧ����������
	 */
	public String getFcrisktaskdesc() {
		return fcrisktaskdesc;
	}

	/**
	 * Ӧ�����������趨
	 *
	 * @param fcrisktaskdesc Ӧ����������
	 */
	public void setFcrisktaskdesc(String fcrisktaskdesc) {
		this.fcrisktaskdesc = fcrisktaskdesc;
	}

	/**
	 * Ӧ�Բ���ȡ��
	 *
	 * @return Ӧ�Բ���
	 */
	public String getFcpolicy() {
		return fcpolicy;
	}

	/**
	 * Ӧ�Բ����趨
	 *
	 * @param fcpolicy Ӧ�Բ���
	 */
	public void setFcpolicy(String fcpolicy) {
		this.fcpolicy = fcpolicy;
	}

	/**
	 * Ӧ��Ŀ�� ȡ��
	 *
	 * @return Ӧ��Ŀ�� 
	 */
	public String getFcoperatoraim() {
		return fcoperatoraim;
	}

	/**
	 * Ӧ��Ŀ�� �趨
	 *
	 * @param fcoperatoraim Ӧ��Ŀ�� 
	 */
	public void setFcoperatoraim(String fcoperatoraim) {
		this.fcoperatoraim = fcoperatoraim;
	}

	/**
	 * Ӧ�Բ���IDȡ��
	 *
	 * @return Ӧ�Բ���ID
	 */
	public String getRiskoperatordept() {
		return riskoperatordept;
	}

	/**
	 * Ӧ�Բ���ID�趨
	 *
	 * @param riskoperatordept Ӧ�Բ���ID
	 */
	public void setRiskoperatordept(String riskoperatordept) {
		this.riskoperatordept = riskoperatordept;
	}

	/**
	 * Ӧ�Բ���ȡ��
	 *
	 * @return Ӧ�Բ���
	 */
	public String getFcoperatordept() {
		return fcoperatordept;
	}

	/**
	 * Ӧ�Բ����趨
	 *
	 * @param fcoperatordept Ӧ�Բ���
	 */
	public void setFcoperatordept(String fcoperatordept) {
		this.fcoperatordept = fcoperatordept;
	}

	/**
	 * Ӧ�Ը�����IDȡ��
	 *
	 * @return Ӧ�Ը�����ID
	 */
	public String getRiskoperator() {
		return riskoperator;
	}

	/**
	 * Ӧ�Ը�����ID�趨
	 *
	 * @param riskoperator Ӧ�Ը�����ID
	 */
	public void setRiskoperator(String riskoperator) {
		this.riskoperator = riskoperator;
	}

	/**
	 * Ӧ�Ը�����ȡ��
	 *
	 * @return Ӧ�Ը�����
	 */
	public String getFcoperator() {
		return fcoperator;
	}

	/**
	 * Ӧ�Ը������趨
	 *
	 * @param fcoperator Ӧ�Ը�����
	 */
	public void setFcoperator(String fcoperator) {
		this.fcoperator = fcoperator;
	}

	/**
	 * ���ͷ����ԱIDȡ��
	 *
	 * @return ���ͷ����ԱID
	 */
	public String getRiskccoperator() {
		return riskccoperator;
	}

	/**
	 * ���ͷ����ԱID�趨
	 *
	 * @param riskccoperator ���ͷ����ԱID
	 */
	public void setRiskccoperator(String riskccoperator) {
		this.riskccoperator = riskccoperator;
	}

	/**
	 * ���ͷ����Աȡ��
	 *
	 * @return ���ͷ����Ա
	 */
	public String getFcccoperator() {
		return fcccoperator;
	}

	/**
	 * ���ͷ����Ա�趨
	 *
	 * @param fcccoperator ���ͷ����Ա
	 */
	public void setFcccoperator(String fcccoperator) {
		this.fcccoperator = fcccoperator;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskreviewresult() {
		return riskreviewresult;
	}

	/**
	 * �������趨
	 *
	 * @param riskreviewresult ������
	 */
	public void setRiskreviewresult(String riskreviewresult) {
		this.riskreviewresult = riskreviewresult;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return EIID;
	}

	public String getRiskdealid() {
		return riskdealid;
	}

	public void setRiskdealid(String riskdealid) {
		this.riskdealid = riskdealid;
	}

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}