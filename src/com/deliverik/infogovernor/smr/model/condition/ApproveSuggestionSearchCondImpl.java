/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * ����: ����������������ʵ��
  * ��������: ����������������ʵ��
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
public class ApproveSuggestionSearchCondImpl implements
		ApproveSuggestionSearchCond {

	/** �������� */
	protected Integer prid_eq;
	
	/** ���������� */
	protected String pidid_eq;
	
	/** ���״̬ */
	protected String status_eq;
	
	/** ����״̬��ʶ */
	protected String psdcode_eq;
	
	/** ���ʽ���к� */
	protected String rownumber_eq;

	/**
	 * ��������ȡ��
	 *
	 * @return prid_eq ��������
	 */
	public Integer getPrid_eq() {
		return prid_eq;
	}

	/**
	 * ���������趨
	 *
	 * @param prid_eq ��������
	 */
	public void setPrid_eq(Integer prid_eq) {
		this.prid_eq = prid_eq;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return pidid_eq ����������
	 */
	public String getPidid_eq() {
		return pidid_eq;
	}
	
	/**
	 * �������趨
	 *
	 * @param pidid_eq ������
	 */
	public void setPidid_eq(String pidid_eq) {
		this.pidid_eq = pidid_eq;
	}

	/**
	 * ���״̬ȡ��
	 *
	 * @return status_eq ���״̬
	 */
	public String getStatus_eq() {
		return status_eq;
	}

	/**
	 * ���״̬�趨
	 *
	 * @param status_eq ���״̬
	 */
	public void setStatus_eq(String status_eq) {
		this.status_eq = status_eq;
	}

	/**
	 * ����״̬��ʶȡ��
	 *
	 * @return psdcode_eq ����״̬��ʶ
	 */
	public String getPsdcode_eq() {
		return psdcode_eq;
	}

	/**
	 * ����״̬��ʶ�趨
	 *
	 * @param psdcode_eq ����״̬��ʶ
	 */
	public void setPsdcode_eq(String psdcode_eq) {
		this.psdcode_eq = psdcode_eq;
	}

	/**
	 * ���ʽ���к�ȡ��
	 * @return rownumber_eq ���ʽ���к�
	 */
	public String getRownumber_eq() {
		return rownumber_eq;
	}

	/**
	 * ���ʽ���к��趨
	 * @param rownumber_eq ���ʽ���к�
	 */
	public void setRownumber_eq(String rownumber_eq) {
		this.rownumber_eq = rownumber_eq;
	}
}