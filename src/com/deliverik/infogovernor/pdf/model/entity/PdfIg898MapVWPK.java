/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ������
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ������
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class PdfIg898MapVWPK extends BasePK implements Serializable {

	/** ����id */
	protected Integer prid;

	/** ������ID */
	protected String pidid;

	/** ���ʽ����ID */
	protected String pvcolpidid;

	/** ���ʽ��ֵ�к� */
	protected String pvrownumber;

	/**
	 * ���캯��
	 */
	public PdfIg898MapVWPK() {

	}

	/**
	 * ���캯��
	 */
	public PdfIg898MapVWPK(Integer prid, String pidid, String pvcolpidid, String pvrownumber) {
		super();
		this.prid = prid;
		this.pidid = pidid;
		this.pvcolpidid = pvcolpidid;
		this.pvrownumber = pvrownumber;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���ʽ����IDȡ��
	 *
	 * @return ���ʽ����ID
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * ���ʽ����ID�趨
	 *
	 * @param pvcolpidid ���ʽ����ID
	 */
	public void setPvcolpidid(String pvcolpidid) {
		this.pvcolpidid = pvcolpidid;
	}

	/**
	 * ���ʽ��ֵ�к�ȡ��
	 *
	 * @return ���ʽ��ֵ�к�
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * ���ʽ��ֵ�к��趨
	 *
	 * @param pvrownumber ���ʽ��ֵ�к�
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

}