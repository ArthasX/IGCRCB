/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ����״̬�����ߵ�����������ʵ��
  * ��������: ����״̬�����ߵ�����������ʵ��
  * ������¼: 2012/05/09
  * �޸ļ�¼: 
  */
public class IG258SearchCondImpl implements
		IG258SearchCond {
	/** ���� */
	protected String pspcdid;

	/** ��ǰ״̬ID */
	protected String psdid;

	/** �ɸı�״̬ID */
	protected String pspcdpsdid;
	
	/** �ɸı�״̬ID */
	protected String pspcdid_like;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPspcdid() {
		return pspcdid;
	}

	/**
	 * �����趨
	 *
	 * @param pspcdid ����
	 */
	public void setPspcdid(String pspcdid) {
		this.pspcdid = pspcdid;
	}

	/**
	 * ��ǰ״̬IDȡ��
	 *
	 * @return ��ǰ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ��ǰ״̬ID�趨
	 *
	 * @param psdid ��ǰ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �ɸı�״̬IDȡ��
	 *
	 * @return �ɸı�״̬ID
	 */
	public String getPspcdpsdid() {
		return pspcdpsdid;
	}

	/**
	 * �ɸı�״̬ID�趨
	 *
	 * @param pspcdpsdid �ɸı�״̬id
	 */
	public void setPspcdpsdid(String pspcdpsdid) {
		this.pspcdpsdid = pspcdpsdid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPspcdid_like() {
		return pspcdid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param pspcdid_like ����
	 */
	public void setPspcdid_like(String pspcdid_like) {
		this.pspcdid_like = pspcdid_like;
	}
	
}