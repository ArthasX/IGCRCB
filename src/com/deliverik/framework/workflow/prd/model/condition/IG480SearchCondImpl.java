/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �����鶨����������ʵ��
  * ��������: �����鶨����������ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG480SearchCondImpl implements
		IG480SearchCond {
	

	/** �����鶨��ID */
	protected String pgdid_like;
	/** ���� */
	protected String pgdname_like;

	/** ���� */
	protected String pgddesc;

	/** ״̬ */
	protected String pgdstatus;

	/** ģ������ */
	protected Integer ptid;

	/**
	 * pgdname   ȡ��
	 * @return pgdname pgdname
	 */
	public String getPgdname_like() {
		return pgdname_like;
	}

	/**
	 * pgdname   �趨
	 * @param pgdname pgdname
	 */
	public void setPgdname_like(String pgdname_like) {
		this.pgdname_like = pgdname_like;
	}

	/**
	 * pgddesc   ȡ��
	 * @return pgddesc pgddesc
	 */
	public String getPgddesc() {
		return pgddesc;
	}

	/**
	 * pgddesc   �趨
	 * @param pgddesc pgddesc
	 */
	public void setPgddesc(String pgddesc) {
		this.pgddesc = pgddesc;
	}

	/**
	 * pgdstatus   ȡ��
	 * @return pgdstatus pgdstatus
	 */
	public String getPgdstatus() {
		return pgdstatus;
	}

	/**
	 * pgdstatus   �趨
	 * @param pgdstatus pgdstatus
	 */
	public void setPgdstatus(String pgdstatus) {
		this.pgdstatus = pgdstatus;
	}

	/**
	 * ptid   ȡ��
	 * @return ptid ptid
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ptid   �趨
	 * @param ptid ptid
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	
	/**
	 * �����鶨��IDȡ��
	 * @return �����鶨��ID
	 */
	public String getPgdid_like() {
		return pgdid_like;
	}

	/**
	 * �����鶨��ID�趨
	 * @param pgdid_like �����鶨��ID
	 */
	public void setPgdid_like(String pgdid_like) {
		this.pgdid_like = pgdid_like;
	}


}