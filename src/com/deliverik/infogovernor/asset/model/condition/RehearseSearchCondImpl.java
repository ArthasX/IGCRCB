/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ������ؼ�������ʵ��
  * ��������: ������ؼ�������ʵ��
  * ������¼: 2014/08/16
  * �޸ļ�¼: 
  */
public class RehearseSearchCondImpl implements RehearseSearchCond {
	
	/** �������������и��������� */
	protected String pivarvalue;
	
	/** ����&&��������״̬ */
	protected String prstatus;

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPivarvalue() {
		return pivarvalue;
	}

	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}


}