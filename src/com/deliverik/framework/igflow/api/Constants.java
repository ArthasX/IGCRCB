/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import com.deliverik.framework.workflow.IGPRDCONSTANTS;

/**
 * ���̶��ο��������ඨ��
 */
public final class Constants {

	/** ���̶�������״̬��ʶ */
	public static final String PD_STATUS_ENABLE = "a";

	/** ���̶������״̬��ʶ */
	public static final String PD_STATUS_TEST = "t";
	
	/** ���̷���״̬��ʶ */
	public static final String PROCESS_STATUS_START = "Z";

	/** ������־ϵͳ���ͱ�ʶ */
	public static final String PROCESS_LOG_TYPE_SYSTEM = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
	
	/** ������־�������ͱ�ʶ */
	public static final String PROCESS_LOG_TYPE_PROCESSING = IGPRDCONSTANTS.RECORDLOG_TYPE_CL;
	
	/** ���ο���������־���� */
	public static final String IGFLOW_LOG_NAME = "igflow";
	
	/** ��ܱ�������_�걨 */
	public static final String REGULATORYREPORT_TYPE_YEAR = "WD1";
	
	/** ��ܱ�������_���� */
	public static final String REGULATORYREPORT_TYPE_SEASON = "WD2";
	
	/** ��ܱ�������_�����ڱ��� */
	public static final String REGULATORYREPORT_TYPE_IRREGULAR = "WD3";

}
