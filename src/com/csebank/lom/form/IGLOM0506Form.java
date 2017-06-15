/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ʳ�ýӴ�����Form
 *
 */
public class IGLOM0506Form extends BaseForm  implements Eentertainment {


	private static final long serialVersionUID = 1L;

	/** �������������� */
	protected Integer eeid;

	/** �Ӵ�����ID */
	protected Integer rid;
	
	/** �Ӵ�����״̬ */
	protected String rstatus;
	
	protected String rname;
	
	/** ������ */
	protected String eeuser;
	
	/** ÿ���˼۸� */
	protected BigDecimal eetableprice;

	/** ���� */
	protected Integer eetablenum;
	
	/** �Ƽ� */
	protected BigDecimal eedrinkprice;
	
	/** �̼� */
	protected BigDecimal eesmokeprice;
	
	/** ������Ʒ�۸� */
	protected BigDecimal eeotherprice;
	
	/** ���� */
	protected String eedate;
	
	/** �Ӵ�ɾ��ID */
	protected String[] deleteEeid;

	/** ��¼�汾��ʶ */
	protected String fingerprint;
	
	/** ʳ�ýӴ���Ϣ��ʼʱ�� */
	protected String eetime_from;
	
	/** ʳ�ýӴ���Ϣ����ʱ�� */
	protected String eetime_to;
	
	protected RecptionTB recptionTB;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";	
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public Integer getEeid() {
		return eeid;
	}
	
	/**
	 * ��������������
	 * @param eid ��������������
	 */
	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}
	
	/**
	 * �Ӵ�����ID
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}
	
	/**
	 * �Ӵ�����ID
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	/**
	 * ������
	 * @return ������
	 */
	public String getEeuser() {
		return eeuser;
	}
	
	/**
	 * ������
	 * @param eeuser ������
	 */
	public void setEeuser(String eeuser) {
		this.eeuser = eeuser;
	}
	
	/**
	 * ÿ���˼۸�
	 * @return ÿ���˼۸�
	 */
	public BigDecimal getEetableprice() {
		return eetableprice;
	}
	
	/**
	 * ÿ���˼۸�
	 * @param eetableprice ÿ���˼۸�
	 */
	public void setEetableprice(BigDecimal eetableprice) {
		this.eetableprice = eetableprice;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public Integer getEetablenum() {
		return eetablenum;
	}
	
	/**
	 * ����
	 * @param eetablenum ����
	 */
	public void setEetablenum(Integer eetablenum) {
		this.eetablenum = eetablenum;
	}
	
	/**
	 * �Ƽ�
	 * @return �Ƽ�
	 */
	public BigDecimal getEedrinkprice() {
		return eedrinkprice;
	}
	
	/**
	 * �Ƽ�
	 * @param eedrinkprice �Ƽ�
	 */
	public void setEedrinkprice(BigDecimal eedrinkprice) {
		this.eedrinkprice = eedrinkprice;
	}
	
	/**
	 * �̼�
	 * @return �̼�
	 */
	public BigDecimal getEesmokeprice() {
		return eesmokeprice;
	}
	
	/**
	 * �̼�
	 * @param eesmokeprice �̼�
	 */
	public void setEesmokeprice(BigDecimal eesmokeprice) {
		this.eesmokeprice = eesmokeprice;
	}
	
	/**
	 * ������Ʒ�۸�
	 * @return ������Ʒ�۸�
	 */
	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}
	
	/**
	 * ������Ʒ�۸�
	 * @param eeotherprice ������Ʒ�۸�
	 */
	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEedate() {
		return eedate;
	}
	
	/**
	 * ����
	 * @param eedate ����
	 */
	public void setEedate(String eedate) {
		this.eedate = eedate;
	}
	
	/**
	 * �Ӵ�ɾ��ID
	 * @return �Ӵ�ɾ��ID
	 */
	public String[] getDeleteEeid() {
		return deleteEeid;
	}
	/**
	 * �Ӵ�ɾ��ID
	 * @param deleteEeid �Ӵ�ɾ��ID
	 */
	public void setDeleteEeid(String[] deleteEeid) {
		this.deleteEeid = deleteEeid;
	}

	/**
	 * ʳ�ýӴ���Ϣ��ʼʱ���ѯȡ��
	 * @return ʳ�ýӴ���Ϣ��ʼʱ���ѯ
	 */
	public String getEetime_from() {
		return eetime_from;
	}

	/**
	 * ʳ�ýӴ���Ϣ��ʼʱ���ѯ�趨
	 * @param eetime_from ʳ�ýӴ���Ϣ��ʼʱ���ѯ
	 */
	public void setEetime_from(String eetime_from) {
		this.eetime_from = eetime_from;
	}

	/**
	 * ʳ�ýӴ���Ϣ����ʱ���ѯȡ��
	 * @return eetime_to ʳ�ýӴ���Ϣ����ʱ���ѯ
	 */
	public String getEetime_to() {
		return eetime_to;
	}

	/**
	 * ʳ�ýӴ���Ϣ����ʱ���ѯ�趨
	 * @param eetime_to ʳ�ýӴ���Ϣ����ʱ���ѯ
	 */
	public void setEetime_to(String eetime_to) {
		this.eetime_to = eetime_to;
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

	public RecptionTB getRecptionTB() {
		return recptionTB;
	}

	public void setRecptionTB(RecptionTB recptionTB) {
		this.recptionTB = recptionTB;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

}
