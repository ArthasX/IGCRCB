/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

/**
 * 
 * @Description:�Զ��������ɱ�ʵ��ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��REPORT_GDATA_ITEM������ΪSOC0201Info
 */
public interface SOC0201Info {
	/**
	 *��������������
	 */
	public Integer getId();

	/**
	 *ͳ������
	 */
	public String getR_category();

	/**
	 *�����ļ�����
	 */
	public String getR_path();

	/**
	 *��������id
	 */
	public Integer getR_rcid();

	/**
	 *����ͳ������
	 */
	public String getR_time();

	/**
	 * @return the ����ID
	 */
	public String getDataid();
}
