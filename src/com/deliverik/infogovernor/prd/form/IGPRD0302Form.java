/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;
import com.deliverik.framework.base.BaseForm;

/**
 * �����鶨���ѯ����Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0302Form extends BaseForm  {

	protected String pgdid;

	/** ���� */
	protected String pgdname;

	/** ���� */
	protected String pgddesc;

	/** ״̬ */
	protected String pgdstatus;

	/** ����ͼxml */
	protected String pgdxml;

	/** ����ʱ�� */
	protected String pgdcrtime;

	/** ���к����ɴ����� */
	protected String serialGenerator;

	/** ģ������ */
	protected Integer ptid;
	
	/**�������̶���ids*/
	protected String[] pdids;
	

	/**
	 * pgdid   ȡ��
	 * @return pgdid pgdid
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * pgdid   �趨
	 * @param pgdid pgdid
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * pgdname   ȡ��
	 * @return pgdname pgdname
	 */
	public String getPgdname() {
		return pgdname;
	}

	/**
	 * pgdname   �趨
	 * @param pgdname pgdname
	 */
	public void setPgdname(String pgdname) {
		this.pgdname = pgdname;
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
	 * pgdxml   ȡ��
	 * @return pgdxml pgdxml
	 */
	public String getPgdxml() {
		return pgdxml;
	}

	/**
	 * pgdxml   �趨
	 * @param pgdxml pgdxml
	 */
	public void setPgdxml(String pgdxml) {
		this.pgdxml = pgdxml;
	}

	/**
	 * pgdcrtime   ȡ��
	 * @return pgdcrtime pgdcrtime
	 */
	public String getPgdcrtime() {
		return pgdcrtime;
	}

	/**
	 * pgdcrtime   �趨
	 * @param pgdcrtime pgdcrtime
	 */
	public void setPgdcrtime(String pgdcrtime) {
		this.pgdcrtime = pgdcrtime;
	}

	/**
	 * serialGenerator   ȡ��
	 * @return serialGenerator serialGenerator
	 */
	public String getSerialGenerator() {
		return serialGenerator;
	}

	/**
	 * serialGenerator   �趨
	 * @param serialGenerator serialGenerator
	 */
	public void setSerialGenerator(String serialGenerator) {
		this.serialGenerator = serialGenerator;
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
	 * pdids   ȡ��
	 * @return pdids pdids
	 */
	public String[] getPdids() {
		return pdids;
	}

	/**
	 * pdids   �趨
	 * @param pdids pdids
	 */
	public void setPdids(String[] pdids) {
		this.pdids = pdids;
	}

	
	
}
