/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ������ֵ��ʵ������
  * ��������: ������ֵ��ʵ������
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG898PK extends BasePK implements Serializable {

	/** �������� */
	protected Integer prid;

	/** ���������� */
	protected String pidid;

	/** �ж������� */
	protected String pvcolpidid;

	/** �к� */
	protected String pvrownumber;

	/**
	 * ���캯��
	 */
	public IG898PK() {

	}

	/**
	 * ���캯��
	 */
	public IG898PK(Integer prid, String pidid, String pvcolpidid, String pvrownumber) {
		super();
		this.prid = prid;
		this.pidid = pidid;
		this.pvcolpidid = pvcolpidid;
		this.pvrownumber = pvrownumber;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 *
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * �ж�������ȡ��
	 *
	 * @return �ж�������
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * �ж��������趨
	 *
	 * @param pidcolpidid �ж�������
	 */
	public void setPvcolpidid(String pvcolpidid) {
		this.pvcolpidid = pvcolpidid;
	}

	/**
	 * �к�ȡ��
	 *
	 * @return �к�
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * �к��趨
	 *
	 * @param pvrownumber �к�
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

}