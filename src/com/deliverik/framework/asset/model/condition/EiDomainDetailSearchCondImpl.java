/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �ʲ�����ϸ���������ʵ��
  * ��������: �ʲ�����ϸ���������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class EiDomainDetailSearchCondImpl implements
		EiDomainDetailSearchCond {
	/**�ʲ���ID**/
	private Integer eiddid;
	/**�ʲ���汾**/
	private Integer eiddversion;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/**��ȡ�ʲ���ID**/
	public Integer getEiddid() {
		return eiddid;
	}
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**��ȡ�ʲ���汾**/
	public Integer getEiddversion() {
		return eiddversion;
	}
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

}