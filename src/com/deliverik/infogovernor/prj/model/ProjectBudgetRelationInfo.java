/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����: Ԥ������Ŀ��ϵ��ʵ��ӿ�
 * ����������Ԥ������Ŀ��ϵ��ʵ��ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public interface ProjectBudgetRelationInfo extends BaseModel{
	/**
	 * ��ϵ������ȡ��
	 * @return pbid ��ϵ������
	 */
	public Integer getPbid() ;
	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() ;
	/**
	 * Ԥ��IDȡ��
	 * @return bid Ԥ��ID
	 */
	public Integer getBid();
	/**
	 * Ԥ���ʱ��𿪷�ȡ��
	 * @return bzdevelop Ԥ���ʱ��𿪷�
	 */
	public Double getBzdevelop() ;
	/**
	 * Ԥ���ʱ���Ӳ��ȡ��
	 * @return bzhardware Ԥ���ʱ���Ӳ��
	 */
	public Double getBzhardware() ;
	/**
	 * Ԥ���ʱ������ȡ��
	 * @return bzsoftware Ԥ���ʱ������
	 */
	public Double getBzsoftware();
	/**
	 * Ԥ���ʱ��𹤳�ȡ��
	 * @return bzproject Ԥ���ʱ��𹤳�
	 */
	public Double getBzproject() ;
	/**
	 * Ԥ���ʱ�������ȡ��
	 * @return bzelse Ԥ���ʱ�������
	 */
	public Double getBzelse();
	/**
	 * Ԥ��ɱ���ʵʩȡ��
	 * @return bcimplement Ԥ��ɱ���ʵʩ
	 */
	public Double getBcimplement() ;
	/**
	 * Ԥ��ɱ�������ȡ��
	 * @return bcelse Ԥ��ɱ�������
	 */
	public Double getBcelse() ;
	/**
	 * ����ʱ��ȡ��
	 * @return pbdatetime ����ʱ��
	 */
	public String getPbdatetime() ;
}
