package com.deliverik.framework.model.condition;

/**
 * ������Ϣ��ѯ����ʵ��
 * 
 */
public class CodeDetailDefSearchCondImpl implements CodeDetailDefSearchCond {

	/** ����CD */
	protected String ccid ;
	
	/** ����CD */
	protected String cid;
	
	/** ����CD(��) */
	protected String pccid;

	/** ����CD(��) */
	protected String pcid;
	
	/** ����CD״̬ */
	protected String cdstatus;
	
	/** ��ѯָ�������¼��� */
	protected String syscoding_q;
	
	/** ��ѯָ����� */
	protected String syscoding;
	
	/**�ʲ�������ϵ������*/
	protected String businesscode_like;
	
	/** ���� */
	protected String clevel;
	
	/**�洢��ֵ*/
	protected String cvalue_like;
	
	
	
	
	public String getCvalue_like() {
		return cvalue_like;
	}

	public void setCvalue_like(String cvalue_like) {
		this.cvalue_like = cvalue_like;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

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
	 * ���ݷ���CD(��)ȡ��
	 * @return ���ݷ���CD(��)
	 */
	public String getPccid() {
		return pccid;
	}

	/**
	 * ���ݷ���CD(��)�趨
	 *
	 * @param pccid ���ݷ���CD(��)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	/**
	 * ����CD(��)ȡ��
	 * @return ����CD(��)
	 */
	public String getPcid() {
		return pcid;
	}

	/**
	 * ����CD(��)�趨
	 *
	 * @param pcid ����CD(��)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	/**
	 * ����CD״̬ȡ��
	 * @return ����CD״̬
	 */
	public String getCdstatus() {
		return cdstatus;
	}
	/**
	 * ����CD״̬�趨
	 *
	 * @param cdstatus ����CD״̬
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}
	/**
	 * �ʲ�������ϵ������ȡ��
	 * @return �ʲ�������ϵ������
	 */
	public String getBusinesscode_like() {
		return businesscode_like;
	}
	/**
	 * �ʲ�������ϵ�������趨
	 *
	 * @param businesscode_like �ʲ�������ϵ������
	 */
	public void setBusinesscode_like(String businesscode_like) {
		this.businesscode_like = businesscode_like;
	}
	
}