/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ���̲鿴��ɫ���ñ��������ʵ��
  * ��������: ���̲鿴��ɫ���ñ��������ʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public class IG700SearchCondImpl implements
		IG700SearchCond {
	
	/** ���̶���ID */
	private String pdid;

	/**
	 * ���̶���IDȡ��
	 * @return
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @return
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	

}