/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.condition;


/**
 * <p>����:Ԥ�㼰���̷�����Ϣ��ͼ��ѯ�����ӿ�</p>
 */

public interface PbsummaryVWSearchCond {
	/**
	 * ��ȡԤ����Ŀ��ϵ��ID
	 * @return Ԥ����Ŀ��ϵ��ID
	 */
	public Integer getPbid();
	
	/**
	 * ��ȡ��ĿID
	 * @return ��ĿID
	 */
	public Integer getPid();
	
	/**
	 * ��ȡԤ���ID
	 * @return Ԥ���ID
	 */
	public Integer getBid();
	
	/**
	 * ��ȡ��ʼԤ�����
	 * @return ��ʼԤ�����
	 */
	public String getByear_begin();
	
	/**
	 * ��ȡ����Ԥ�����
	 * @return ����Ԥ�����
	 */
	public String getByear_end();
}
