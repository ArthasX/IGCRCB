/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * ����:ͬ���澯ϵͳ��ͼ��ѯ����ʵ��
 * ��������: ͬ���澯ϵͳ��ͼ��ѯ����ʵ��
 * �����ˣ�����
 * ������¼: 2014/04/03
 * �޸ļ�¼: 
 */

public class SynchronizationAlarmSystemVWSearchCondImpl implements
	SynchronizationAlarmSystemVWSearchCond {
	
	/**ͬ������  */
	protected String itype;

	/**ͬ������ȡ�� */
	public String getItype() {
		return itype;
	}

	/**ͬ�������趨 */
	public void setItype(String itype) {
		this.itype = itype;
	}
}
