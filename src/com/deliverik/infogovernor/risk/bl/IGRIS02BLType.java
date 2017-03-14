/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.bl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�����SVC���¼�ҵ���߼����賣��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGRIS02BLType {
	
	/*------------------�¼�״̬------------------*/

	/** ���� */
	public static final String PROCESS_STATUS_WAITING_INIT = "I";
	/** �ȴ����� */
	public static final String PROCESS_STATUS_WAITING_DISPATCH = "P";
	/** �ȴ�ȷ�� */
	public static final String PROCESS_STATUS_WAITING_CONFIRM = "D";
	/** �ȴ����� */
	public static final String PROCESS_STATUS_WAITING_IMPLEMENT = "E";
	/** �ȴ���� */
	public static final String PROCESS_STATUS_WAITING_VERIFY = "V";
	/** �Ѿ��ر� */
	public static final String PROCESS_STATUS_CLOSE = "C";
	
	/** �ȴ����� */
	public static final char PROCESS_STATUS_WAITING_DISPATCH_CHAR = 'P';
	/** �ȴ����� */
	public static final char PROCESS_STATUS_WAITING_IMPLEMENT_CHAR = 'E';
	/** �ȴ���� */
	public static final char PROCESS_STATUS_WAITING_VERIFY_CHAR = 'V';
	/** �Ѿ��ر� */
	public static final char PROCESS_STATUS_CLOSE_CHAR = 'C';
	
	/** Ԥ���� */
	public static final String PARTICIPANT_STATUS_DREFT = "D";

	/*------------------�¼�������״̬------------------*/
	
	/** ���� */
	public static final String PARTICIPANT_STATUS_INITIAL = "I";
	/** ���� */
	public static final String PARTICIPANT_STATUS_DISPATCH = "P";
	/** ���� */
	public static final String PARTICIPANT_STATUS_IMPLEMENT = "E";
	/** ��� */
	public static final String PARTICIPANT_STATUS_VERIFY = "V";

	/*------------------�¼�������ܳ��ֵĽ��(��ʱû��)------------------*/

	/** ����ͨ�� */
	public static final String PARTICIPANT_RESULTS_YES = "Y";
	/** ������ͨ�� */
	public static final String PARTICIPANT_RESULTS_NO = "N";
	/** �쳣��ֹ */
	public static final String PARTICIPANT_RESULTS_CANCEL = "C";
	/** ���ͨ�� */
	public static final String PARTICIPANT_RESULTS_SUCCESS = "S";
	/** ��˲�ͨ�� */
	public static final String PARTICIPANT_RESULTS_FAIL = "F";
	
	public static final String PROCESS_RLDESC_INITIAL_MESSAGE = "�����¼�";
	public static final String PROCESS_RLDESC_ADD_COMMENT_MESSAGE = "������Ϣ";
	public static final String PROCESS_RLDESC_UPD_PROCESSRECORD_MESSAGE = "����������Ϣ";
	public static final String PROCESS_RLDESC_NOTARIZE_MESSAGE = "ȷ���¼�";
	public static final String PROCESS_RLDESC_ADD_IMPLEMENTOR_MESSAGE = "��Ӵ�����";
	public static final String PROCESS_RLDESC_ASSIGNPERSON_MESSAGE = "�趨ִ����";
	public static final String PROCESS_RLDESC_ADD_VERIFIOR_MESSAGE = "��������";
	public static final String PROCESS_RLDESC_REMOVE_VERIFIOR_MESSAGE = "ɾ�������";
	public static final String PROCESS_RLDESC_REMOVE_IMPLEMENTOR_MESSAGE = "ɾ��������";
	public static final String PROCESS_RLDESC_ADD_ASSIGN_MESSAGE = "���ɴ�����";
	public static final String PROCESS_RLDESC_IMPLEMENT_MESSAGE = "�����¼�";
	public static final String PROCESS_RLDESC_TERMINATE_MESSAGE = "��ֹ�¼�";
	public static final String PROCESS_RLDESC_CONFIRM_MESSAGE = "ȷ���¼�";
	public static final String PROCESS_RLDESC_ADJUST_LEVEL_MESSAGE = "�����¼�����";
	public static final String PROCESS_RLDESC_VERIFY_SUCCESS_MESSAGE = "��˽����ͨ��";
	public static final String PROCESS_RLDESC_VERIFY_FAIL_MESSAGE = "��˽������ͨ��";
	
	public static final String ACTION_NONE = "None";
	//�¼���ϸҳ���е�ActionName
	public static final String PROCESS_ACTION_ADDCOMMENT = "ACT01SVC02031";
	public static final String PROCESS_ACTION_IMPLEMENTORS = "ACT01SVC02032";
	public static final String PROCESS_ACTION_VERIFIORS = "ACT01SVC02033";
	public static final String PROCESS_ACTION_IMPLEMENT = "ACT01SVC02034";
	public static final String PROCESS_ACTION_VERIFY = "ACT01SVC02035";
	public static final String PROCESS_ACTION_ADJUSTLEVEL = "ACT01SVC02036";
	public static final String PROCESS_ACTION_TERMINATE = "ACT01SVC02037";
	public static final String PROCESS_ACTION_DISPATCH = "ACT01SVC02038";
	public static final String PROCESS_ACTION_MANAGER = "ACT01SVC02039";
	
	//�¼�ҳ���е�info��
	public static final String PROCESS_PRT_USERNAME = "����������";
	public static final String PROCESS_PRT_ORGNAME = "�����˲���";
	public static final String PROCESS_PRT_ORGSYSCODING = "�����˲��ű���";
	public static final String PROCESS_PRT_USERCONNECT = "��������ϵ��ʽ";
	public static final String PROCESS_AFT_USERNAME = "Ӱ��������";
	public static final String PROCESS_AFT_ORGNAME = "Ӱ���˲���";
	public static final String PROCESS_AFT_ORGSYSCODING = "Ӱ���˲��ű���";
	public static final String PROCESS_AFT_USERCONNECT = "Ӱ������ϵ��ʽ";
	
	public static final String PROCESS_PRT_USERNAME_ID = "PRT_USERNAME";
	public static final String PROCESS_PRT_ORGNAME_ID = "PRT_ORGNAME";
	public static final String PROCESS_PRT_ORGSYSCODING_ID = "PRT_ORGSYSCODING";
	public static final String PROCESS_PRT_USERCONNECT_ID = "PRT_USERCONNECT";
	public static final String PROCESS_AFT_USERNAME_ID = "AFT_USERNAME";
	public static final String PROCESS_AFT_ORGNAME_ID = "AFT_ORGNAME";
	public static final String PROCESS_AFT_ORGSYSCODING_ID = "AFT_ORGSYSCODING";
	public static final String PROCESS_AFT_USERCONNECT_ID = "AFT_USERCONNECT";

	public static final String OPTION_TYPE = "2";
	
	
	/*------------------��־��Ϣ------------------*/
	public static final String COMMENT_WAITING_DISPATCH = "�ȴ�����";
	public static final String COMMENT_DISPATCH = "�Ѿ�����";
	public static final String COMMENT_WAITING_IMPLEMENT = "�ȴ�����";
	public static final String COMMENT_IMPLEMENT = "�Ѿ�����";
	public static final String COMMENT_WAITING_VERIFY = "�ȴ����";
	public static final String COMMENT_VERIFY = "�Ѿ����";
	public static final String COMMENT_SAVE_INITIALOR = "���淢����";
	public static final String COMMENT_SAVE_DISPATCHOR = "���������";
	public static final String COMMENT_SAVE_VERIFIOR = "���������";
	
	public static final String STATUS_COMMENT_DISPATCH = "����״̬ת���ȴ�����";
	public static final String STATUS_COMMENT_CONFIRM = "����״̬ת���ȴ�ȷ��";
	public static final String STATUS_COMMENT_IMPLEMENT = "����״̬ת���ȴ�����";
	public static final String STATUS_COMMENT_VERIFY = "����״̬ת���ȴ����";
	public static final String STATUS_COMMENT_CLOSE = "�����Ѿ��ر�";
	
	public static final String COMMENT_MESSAGE_DISPATCH = "���з���";
	public static final String COMMENT_MESSAGE_ADJUST = "����";
	/*------------------��������״̬��Ϣ------------------*/
	/** ��ȷ�� */
	public static final String PROCESS_SUB_STATUS_CONFIRMED = "0";
	/** δȷ�� */
	public static final String PROCESS_SUB_STATUS_CONFIRM = "1";
	
	
	/*------------------��������-----------------------*/
	/** �¼� */
	public static final String PROCESS_INCIDENT_I = "1";
	/** �Զ����¼� */
	public static final String PROCESS_INCIDENT_ID = "9";
}
