/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ��
 */
package com.deliverik.framework.soc.asset.model.entity;


/**
 * ����: 
 * ��������: 
 * ������¼: ����ȫ 2012-7-25
 * �޸ļ�¼: 
 */
public class CodeDetailEntity {
	/** ���ݷ���CD */
	protected String ccid ;
	
	/** ����CD */
	protected String cid;
	
	/** �������� */
	protected String cvalue;

	/** ���ݷ�����(��) */
	protected String pccid;

	/** ���ݱ��(��) */
	protected String pcid;

	/** ����ʱ�� */
	protected String updtime;
	
	/** ����� */
	public String syscoding;
	
	/** �ϼ������ */
	public String psyscoding;
	
	/** ״̬ 0-ͣ�ã�1-���� */
	public String cdstatus;
	
	/** ����ҵ���� */
	public String businesscode;
	
	/** ����˵�� */
	public String cdinfo;

	/**
	 * ���ݷ���CDȡ��
	 *
	 * @return ccid ���ݷ���CD
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
	 *
	 * @return cid ����CD
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
	 *
	 * @return cvalue ��������
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
	 *
	 * @return pccid ���ݷ�����(��)
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
	 *
	 * @return pcid ���ݱ��(��)
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
	 *
	 * @return updtime ����ʱ��
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
	 * �����ȡ��
	 *
	 * @return syscoding �����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * ������趨
	 *
	 * @param syscoding �����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * �ϼ������ȡ��
	 *
	 * @return psyscoding �ϼ������
	 */
	public String getPsyscoding() {
		return psyscoding;
	}

	/**
	 * �ϼ�������趨
	 *
	 * @param psyscoding �ϼ������
	 */
	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	/**
	 * ״̬0-ͣ�ã�1-����ȡ��
	 *
	 * @return cdstatus ״̬0-ͣ�ã�1-����
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * ״̬0-ͣ�ã�1-�����趨
	 *
	 * @param cdstatus ״̬0-ͣ�ã�1-����
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	/**
	 * ����ҵ����ȡ��
	 *
	 * @return businesscode ����ҵ����
	 */
	public String getBusinesscode() {
		return businesscode;
	}

	/**
	 * ����ҵ�����趨
	 *
	 * @param businesscode ����ҵ����
	 */
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}

	/**
	 * ����˵��ȡ��
	 *
	 * @return cdinfo ����˵��
	 */
	public String getCdinfo() {
		return cdinfo;
	}

	/**
	 * ����˵���趨
	 *
	 * @param cdinfo ����˵��
	 */
	public void setCdinfo(String cdinfo) {
		this.cdinfo = cdinfo;
	}
	
	
}
