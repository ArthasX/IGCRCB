/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:�Զ����������б�Cond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationSearchCond������ΪSOC0203SearchCond
 */
public interface SOC0203SearchCond{
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
 * ����ID
 * @return ����ID
 */
public String getDataid();

}

