/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ���̲������Ѽ�������ʵ��
  * ��������: ���̲������Ѽ�������ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public class IG256SearchCondImpl implements
		IG256SearchCond {

	/** ����ID */
	private Integer prid;
	
	/** ���̵�ǰ״̬ */
	private String prstatus;

	private String flag;

	private String[] flag_in;

	/**
	 * ��������ID��ֵ��ѯ
	 * @param prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ȡ����ID
	 * @return
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ��������״̬��ֵ��ѯ
	 * @param prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ȡ����״̬
	 * @return
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ֪ͨ��ʶ���� ֵ�� 0:֪ͨ 1:��ʱ
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ֪ͨ��ʶ��ȡ 
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * ֪ͨ��ʶ in ��ѯ
	 * @param flag_in
	 */
	public void setFlag_in(String[] flag_in) {
		this.flag_in = flag_in;
	}

	/**
	 * ��ȡ֪ͨ��ʶ in
	 * @return
	 */
	public String[] getFlag_in() {
		return flag_in;
	}

}