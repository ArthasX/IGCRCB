/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

/**
 * 
 * @Description:�Զ����������б�ʵ��ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfiguration������ΪSOC0203Info
 */
public interface SOC0203Info {
	/**
	 *��������������
	 */
	public Integer getId();

	/**
	 *�����ļ�������
	 */
	public String getR_path();

	/**
	 *�����ļ������ĺ���
	 */
	public String getR_title();

	/**
	 *��������ʱ���õĲ���
	 */
	public String getPara();

	/**
	 * @return the ����ID
	 */
	public String getDataid();

}
