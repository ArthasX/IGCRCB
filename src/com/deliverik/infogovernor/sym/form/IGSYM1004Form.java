package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.CodeDetail;

/**
 * ������ϸ��Ϣ�༭����FORM
 * 
 */
public class IGSYM1004Form extends BaseForm implements CodeDetail{

	private static final long serialVersionUID = 1L;

	/** ���ݷ���CD */
	protected String ccid ;
	
	/** ���ݷ���CD */
	protected String ccname ;
	
	/** ����CD */
	protected String cid;
	
	/** �������� */
	protected String cvalue;

	/** ���ݷ�����(��) */
	protected String pccid;

	/** ���ݷ�������(��) */
	protected String pccname;

	/** ���ݱ��(��) */
	protected String pcid;

	/** ����˵��(��) */
	protected String pcvalue;

	/** ����ʱ�� */
	protected String updtime;

	/** �༭ģʽ���Ǽ�/�����  */
	protected String mode = "0";
	
	/** ����Ǩ�Ʊ�ʶ */
	protected String route = "0";
	
	/** ����� */
	public String syscoding;
	
	/** �ϼ������ */
	public String psyscoding;
	
	/** ״̬ 0-ͣ�ã�1-���� */
	public String cdstatus;
	
	/** ����ҵ���� */
	public String businesscode;
	
	/** ���� */
	public String clevel;
	
	/** ����˵���ֶ� */
	protected String cdinfo;

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * ����CD�趨
	 *
	 * @param cid ����CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getCvalue() {
		return cvalue;
	}


	/**
	 * ���������趨
	 *
	 * @param cvalue ��������
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}


	/**
	 * ���ݷ�����(��)ȡ��
	 * @return ���ݷ�����(��)
	 */
	public String getPccid() {
		return pccid;
	}


	/**
	 * ���ݷ�����(��)�趨
	 *
	 * @param pccid ���ݷ�����(��)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}


	/**
	 * ���ݱ��(��)ȡ��
	 * @return ���ݱ��(��)
	 */
	public String getPcid() {
		return pcid;
	}


	/**
	 * ���ݱ��(��)�趨
	 *
	 * @param pcid ���ݱ��(��)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}


	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getUpdtime() {
		return updtime;
	}


	/**
	 * ����ʱ���趨
	 *
	 * @param updtime ����ʱ��
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}


	/**
	 * ����Ǩ�Ʊ�ʶȡ��
	 * @return ����Ǩ�Ʊ�ʶ
	 */
	public String getRoute() {
		return route;
	}


	/**
	 * ����Ǩ�Ʊ�ʶ�趨
	 *
	 * @param route ����Ǩ�Ʊ�ʶ
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	public String getPccname() {
		return pccname;
	}

	public void setPccname(String pccname) {
		this.pccname = pccname;
	}

	public String getPcvalue() {
		return pcvalue;
	}

	public void setPcvalue(String pcvalue) {
		this.pcvalue = pcvalue;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	
	/**
	 * �����
	 * @return �����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * �����
	 *
	 * @param syscoding �����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * �ϼ������
	 * @return �ϼ������
	 */
	public String getPsyscoding() {
		return psyscoding;
	}

	/**
	 * �����
	 *
	 * @param syscoding �����
	 */
	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	/**
	 * ״̬ 0-ͣ�ã�1-����
	 * @return ״̬
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * ״̬ 0-ͣ�ã�1-����
	 *
	 * @param cdstatus ״̬
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	/**
	 * ����ҵ����
	 * @return ����ҵ����
	 */
	public String getBusinesscode() {
		return businesscode;
	}

	/**
	 * ����ҵ����
	 *
	 * @param businesscode ����ҵ����
	 */
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getClevel() {
		return clevel;
	}

	/**
	 * ����
	 *
	 * @param clevel ����
	 */
	public void setClevel(String clevel) {
		this.clevel = clevel;
	}
	
	public String getCdinfo() {
		return cdinfo;
	}

	public void setCdinfo(String cdinfo) {
		this.cdinfo = cdinfo;
	}

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getCdorder() {
		// TODO Auto-generated method stub
		return null;
	}
}
