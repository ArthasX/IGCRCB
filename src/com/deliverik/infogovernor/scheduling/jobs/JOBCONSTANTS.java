/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.jobs;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_������س���
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class JOBCONSTANTS {
	
	//*******************************�¼��ල*******************************
	
	//�¼��ල�������ʶ
	public final static String INCIDENT_MONITOR_GROUP = "INCIDENT_MONITOR_GROUP";
	
	//�¼��ල������ʶ
	public final static String INCIDENT_MONITOR = "INCIDENT_MONITOR";
	
	//�¼��ල�������ʶ
	public final static String INCIDENT_MONITOR_TRI_GROUP = "INCIDENT_MONITOR_TRI_GROUP";
	
	//�¼��ල������ʶ
	public final static String INCIDENT_MONITOR_TRI = "INCIDENT_MONITOR_TRI";
	
	//3����һ���
	public final static int INCIDENT_INTERVAL = 3;
	
	//�¼��ල�������ڱ��ʽ��3����  
	public final static String INCIDENT_MONITOR_PARSE = "0 */"+INCIDENT_INTERVAL+" * * * ?";
	
	
}
