/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * ����: �����˱��������ʵ��
  * ��������: �����˱��������ʵ��
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public class CopyReadUserSearchCondImpl implements
		CopyReadUserSearchCond {

	
	/** �������� */
	protected String prtitle;
	
	/** ������id */
	protected String pruserid ;
	
	/** �Ƿ�鿴��ʶ */
	protected String islook;
	
	/** �������� */
	protected Integer prid;
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���������趨
	 *
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPruserid () {
		return pruserid ;
	}

	/**
	 * ������id�趨
	 *
	 * @param pruserid  ������id
	 */
	public void setPruserid (String pruserid ) {
		this.pruserid  = pruserid ;
	}
	/**
	 * �Ƿ�鿴��ʶȡ��
	 *
	 * @return �Ƿ�鿴��ʶ
	 */
	public String getIslook() {
		return islook;
	}

	/**
	 * �Ƿ�鿴��ʶ�趨
	 *
	 * @param islook �Ƿ�鿴��ʶ
	 */
	public void setIslook(String islook) {
		this.islook = islook;
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
	
	
}