/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 
 * ��ʷ����ͳ����ͼ��ѯ�ӿ�ʵ��
 *
 */
public class HWorkVWSearchCondImpl implements HWorkVWSearchCond {
	
	/**����ʱ��*/
	protected String propentime ;
	/**������Ա*/
	protected String pruserid;
	public String getPropentime() {
		return propentime;
	}
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	public String getPruserid() {
		return pruserid;
	}
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	
}
