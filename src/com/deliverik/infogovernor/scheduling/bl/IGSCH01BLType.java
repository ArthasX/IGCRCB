/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.bl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_��������
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSCH01BLType {
	/*------------------����״̬------------------*/

	/** �ȴ����� */
	public static final String PROCESS_STATUS_WAITING_ASSIGNEE = "P";
	/** �ȴ���� */
	public static final String PROCESS_STATUS_WAITING_VERIFY = "V";
	/** �ȴ����� */
	public static final String PROCESS_STATUS_WAITING_IMPLEMENT = "E";
	

	/*------------------���̲�����״̬------------------*/
	
	/** ��� */
	public static final String PARTICIPANT_STATUS_VERIFY = "V";
	/** ����*/
	public static final String PARTICIPANT_STATUS_DISPATCHER = "P";
	/** ���� */
	public static final String PARTICIPANT_STATUS_INITIAL = "I";
	/** ���� */
	public static final String PARTICIPANT_STATUS_IMPLEMENT = "E";
	
	/*------------------�����û���������------------------*/
	
	public static final String PARTICIPANT_TYPE = "P";
	
	
	/** ��������*/
	public static final String PROCESS_ENTERPRISE_TYPE = "WA";
	
	public static final String PROCESS_ENTERPRISE_NAME = "ָ�ɹ���";
	
	public static final String PROCESS_PERSON_TYPE = "WB";
	
	public static final String PROCESS_PERSON_NAME = "���˹���";

}
