/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow;

/**
 * ���̶��������������
 *
 */
public final class IGPRDCONSTANTS {
	
	/*--------------- �������� --------------*/
	/** �����˽�ɫ */
	public static final String OA_ROLE_A = "A";
	/** ֵ���˽�ɫ */
	public static final String OA_ROLE_B = "B";
	/** ִ���˽�ɫ */
	public static final String OA_ROLE_C = "C";
	//-----------������Ϣ���Ͷ���-----------
	
	/** ������Ϣ������IG */
	public static final String IG_PROCESSRECORD = "IG";
	
	/** ������־��Ȩ�� */
	public static final String RECORDLOG_PERMISSION_YES = "1";
	
	/** ������־��Ȩ�� */
	public static final String RECORDLOG_PERMISSION_NO = "0";
	
	
	//-----------��������-----------
	
	/** ��Ȩ�� */
	public static final String HAVE_PERMISSION = "checked";
	
	/** ѡ�� */
	public static final String SELECTED = "1";
	
	/** δѡ�� */
	public static final String CANCEL = "0";
	
	/** ����ȱʡ */
	public static final String PUBLIC_ACCESS_DEFAULT = "0";
	
	/** �������ɼ� */
	public static final String PUBLIC_ACCESS_HIDE = "1";
	
	/** ����ֻ�� */
	public static final String PUBLIC_ACCESS_READABLE = "2";
	
	/** ������д */
	public static final String PUBLIC_ACCESS_WRITEABLE = "3";
	
	/** ˽�б���ȫ���ɼ� */
	public static final String PRIVATE_ACCESS_READABLE_ALL = "4";
	
	/** ��ģʽ������ */
	public static final String PIDMODE_PUBLIC = "0";
	
	/** ��ģʽ��˽�� */
	public static final String PIDMODE_PRIVATE = "1";
	
	/** ��ģʽ��״̬ */
    public static final String PIDMODE_STATUS = "2";
	
	/** ����ʾģʽ������ */
	public static final String PIDROWWIDTH_FULL = "0";
	
	/** ����ʾģʽ������ */
	public static final String PIDROWWIDTH_HALF = "1";
	
	/** ����������ʾģʽ���ɼ� */
	public static final String PROCESSTITLE_DEFAULT = "0";
	
	/** ����������ʾģʽ�����ɼ� */
	public static final String PROCESSTITLE_HIDE = "1";
	
	/** ˽�б���Ȩ�޷�Χ����ɫ */
	public static final String PRIVATESCOPE_ROLE = "0";
	
	/** ˽�б���Ȩ�޷�Χ���û� */
	public static final String PRIVATESCOPE_USER = "1";

	/** ˽�б���Ȩ�޷�Χ������ */
	public static final String PRIVATESCOPE_ORG = "2";
	
	/** �ɱ����ɲ��������ͣ���ɫ */
	public static final String PSDASSIGN_ROLE = "1";
	
	/** �ɱ����ɲ��������ͣ��û� */
	public static final String PSDASSIGN_USER = "0";

	//====>130225Begin
	/** �ɱ����ɲ��������ͣ����� */
	public static final String PSDASSIGN_ORG = "2";
	//====>130225End	
	
	/** �ɱ����ɲ����߻������ˣ��� */
	public static final String PSDORG_YES = "0";
	
	/** �ɱ����ɲ����߻������ˣ��� */
	public static final String PSDORG_NO = "1";
	
	/** ����ͼaction��id���Ե�Ĭ����ʼ��ĸ */
	public static final String IMG_ACTION_ID_BEGIN_WITH = "a";
	
	/** ���Ƿ����� */
	public static final String PID_REQUIRED_NO = "0";
	/** ���Ƿ����� */
	public static final String PID_REQUIRED_YES = "1";
	
	/** �ɱ����ɣ��� */
	public static final String ASSIGN_NO = "0";
	//-----------��ť-----------
	
	
	public static final String BUTTON_UPDATE = "01";//����
	
	public static final String BUTTON_CONFIRM = "02";//ȷ��
	
	public static final String BUTTON_TERMINATE = "03";//��ֹ
	
	public static final String BUTTON_EXECUTOR = "04";//����������
	
    public static final String BUTTON_PROCESS = "05";//��ط���
    
    public static final String BUTTON_KNGSEARCH = "06";//֪ʶ��ѯ
    
    public static final String BUTTON_COPYREADING = "07";//֪ʶ��ѯ
    
    public static final String BUTTON_NSBUTTON1 = "08";//��ԾǨ��ť1
    
	public static final String BUUTON_NSBUTTON2 = "09";//��ԾǨ��ť2
    
	public static final String BUTTON_SUBMIT = "10";//�ύ
	
	public static final String BUTTON_APPROVE = "11";//���
	
	public static final String BUTTON_DENY = "12";//����
	
	public static final String BUTTON_BUTTON1 = "13";//���䰴ť1
	
	public static final String BUTTON_BUTTON2 = "14";//���䰴ť2
	
	public static final String BUTTON_BUTTON3 = "15";//���䰴ť3
	
	public static final String BUTTON_BUTTON4 = "16";//���䰴ť4
	
	public static final String BUTTON_BUTTON5 = "17";//���䰴ť5
	
	public static final String BUTTON_PBDFLAG_1 = "1";//����ԾǨ��ť
	
	public static final String BUTTON_PBDFLAG_0 = "0";//��ԾǨ��ť
	
	//-----------�߼�����-----------
	public static final String LOGICSIGN1  = "1";//�Ⱥ�
	public static final String LOGICSIGN2  = "2";//���Ⱥ�
	public static final String LOGICSIGN3  = "3";//���ں�
	public static final String LOGICSIGN4  = "4";//С�ں�
	public static final String LOGICSIGN5  = "5";//���ڵ��ں�
	public static final String LOGICSIGN6  = "6";//С�ڵ��ں�
	
	//-----------Ig259-----------
	/** ���̶����¼�ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_I = 1;
	
	/** ���̶�������ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_P = 2;
	
	/** ���̶�����ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_C = 3;
	
	/** ���̶��巢��ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_D = 4;
	
	/** ���̶����������ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_S = 5;
	
	/** ���̶���ָ��ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_WA = 7;
	
	/** ���̶������ģ��ID */
	public static final Integer PROCESS_DEFINITION_TEMPLATE_WB = 6;
	
	/** ���̶���ͨ��ģ��ID */
	public static final Integer PROCESS_DEFINITION_COMMON_TEMPLATE_ID = 8;
	
	/** �Զ����¼�ģ��ID */
	public static final Integer PROCESS_DEFINITION_ID = 9;
	
	/** �Զ�������ģ��ID */
	public static final Integer PROCESS_DEFINITION_PD = 10;
	
	/** �Զ���Ӧ������ģ��ID */
	public static final Integer PROCESS_DEFINITION_DRM = 20;
	
	/** �Զ���Ԥ�����̹���ģ��ID */
	public static final Integer PROCESS_DEFINITION_WDP = 22;
	
	/** �Զ���ָ�����̹���ģ��ID */
	public static final Integer PROCESS_DEFINITION_WDC = 21;
	
	
	/** �Զ�����ģ��ID */
	public static final Integer PROCESS_DEFINITION_CD = 11;
	
	/** �Զ��巢��ģ��ID */
	public static final Integer PROCESS_DEFINITION_DD = 12;
	
	/** �Զ����������ģ��ID */
	public static final Integer PROCESS_DEFINITION_SD = 13;
	
	/** ���̶���ͨ��ģ���ʶ */
	public static final String PROCESS_DEFINITION_TYPE_WD = "WD";
	
	/** �Զ���ͨ��ģ��״̬��ʶ������ͨ���Զ�������ʱPDID�ĵ�һλ�� */
	public static final String PRTYPE_DEFINITION_TYPE_WD_STATUS_ID = "0";
	
	/** �Զ����¼�ģ���ʶ */
	public static final String PROCESS_DEFINITION_TYPE_ID = "ID"; 
	
	/** �Զ�������ģ���ʶ */
	public static final String PROCESS_DEFINITION_TYPE_PD = "PD";
	
	/** �Զ�����ģ���ʶ */
	public static final String PROCESS_DEFINITION_TYPE_CD = "CD";
	
	/** �Զ��巢��ģ���ʶ */
	public static final String PROCESS_DEFINITION_TYPE_DD = "DD";
	
	/** �Զ����������ģ���ʶ */
	public static final String PROCESS_DEFINITION_TYPE_SD = "SD";

	/**�Զ���Ӧ������ģ���ʾ*/
	public static final String PROCESS_DEFINITION_TYPE_DRM = "DRM";
	
	/**�Զ���Ԥ�����̹���ģ���ʾ*/
	public static final String PROCESS_DEFINITION_TYPE_WDP = "WDP";
	
	/**�Զ���ָ�����̹���ģ���ʾ*/
	public static final String PROCESS_DEFINITION_TYPE_WDC = "WDC";

	/** �Զ����걨ģ���ʶ */
	public static final String PRTYPE_YEAR = "WD1";
	
	/** �Զ����걨ģ��ID */
	public static final Integer PRTYPE_YEAR_ID = 14;
	
	/** �Զ����걨ģ��״̬��ʶ�������걨����ʱPDID�ĵ�һλ�� */
	public static final String PRTYPE_YEAR_STATUS_ID = "1";
	
	/** �Զ��弾��ģ���ʶ */
	public static final String PRTYPE_SEASON = "WD2";
	
	/** �Զ��弾��ģ��ID */
	public static final Integer PRTYPE_SEASON_ID = 15;

	/** �Զ��弾��ģ��״̬��ʶ�����ɼ�������ʱPDID�ĵ�һλ�� */
	public static final String PRTYPE_SEASON_STATUS_ID = "2";
	
	/** �Զ��岻����ģ���ʶ */
	public static final String PRTYPE_IRREGULAR = "WD3";
	
	/** �Զ��岻����ģ��ID */
	public static final Integer PRTYPE_IRREGULAR_ID = 16;
	
	/** �Զ��岻����ģ��״̬��ʶ�����ɲ���������ʱPDID�ĵ�һλ�� */
	public static final String PRTYPE_IRREGULAR_STATUS_ID = "3";
	
	/** �Զ����±�ģ��״̬��ʶ�������±�����ʱPDID�ĵ�һλ�� */
	public static final String PRTYPE_MONTH_STATUS_ID = "4";
	
	/** �Զ����±�ģ���ʶ */
	public static final String PRTYPE_MONTH = "WD4";
	
	/** �Զ����±�ģ��ID */
	public static final Integer PRTYPE_MONTH_ID = 13;
	
	/** �¼�ģ���ʶ */
	public static final String PROCESS_TYPE_I = "I"; 

	/** �����ʶ */
	public static final String PROCESS_TYPE_P = "P"; 
	
	/** ���ģ���ʶ */
	public static final String PROCESS_TYPE_C = "C"; 
	
	/** ����ģ���ʶ */
	public static final String PROCESS_TYPE_D = "D"; 
	
	/** ��������ģ���ʶ */
	public static final String PROCESS_TYPE_S = "S"; 
	
	/** Ӧ��ָ������ģ���ʶ */
	public static final String PROCESS_TYPE_WDC = "WDC";
	/** Ӧ��ָ������ģ���ʶID */
	public static final Integer PROCESS_TYPE_WDC_ID = 18;
	
	/** Ԥ������ģ���ʶ */
	public static final String PROCESS_TYPE_WDP = "WDP";
	/** Ԥ������ģ���ʶID */
	public static final Integer PROCESS_TYPE_WDP_ID = 19;
	
	/** ����δ�رյ�������ʹ��ģ�� */
	public static final String PROCESSDEFINITION_IS_IN_USE = "1";
	
	/** ������δ�رյ�������ʹ��ģ�� */
	public static final String PROCESSDEFINITION_IS_NOT_IN_USE = "0";
	
	//-----------ProcessDefinition-----------
	
	/** ���̶���״̬ ����*/
	public static final String PD_STATUS_ENABLE = "a";
	
	/** ���̶���״̬ ͣ��*/
	public static final String PD_STATUS_DISABLE = "i";
	
	/** ���̶���״̬ ����*/
	public static final String PD_STATUS_TESTABLE = "t";
	
	/** �����鶨��״̬ ����*/
	public static final String PGD_STATUS_ENABLE = "2";
	
	/** �����鶨��״̬ ͣ��*/
	public static final String PGD_STATUS_DISABLE = "0";
	
	/** �����鶨��״̬ ����*/
	public static final String PGD_STATUS_TESTABLE = "1";
	
	/** ���̶���������ݱ�ʾ*/
	public static final String PD_TEST_ID = "1";
	
	//-----------IG333-----------
	
	/** ����Ĭ�Ͽ�ʼ״̬*/
	public static final String PROCESS_START_STATUS = "Z";
	
	/** ����Ĭ�Ͽ�ʼ״̬˵��*/
	public static final String PROCESS_START_STATUS_DESC = "����Ĭ�Ͽ�ʼ״̬";
	
	/** ����Ĭ�Ͽ�ʼ״̬��ʾ����*/
	public static final String PROCESS_START_STATUS_LABEL = "������";
	
	/** ����Ĭ�Ͻ���״̬*/
	public static final String PROCESS_END_STATUS = "C";

	/** ������Ĭ�Ͻ���״̬*/
	public static final String PROCESS_END_SUBSTATUS = "B";
	
	/** ������ֹ״̬ */
	public static final String PROCESS_TERMINATE = "#";
	
	/** ����Ĭ�Ͻ���״̬˵��*/
	public static final String PROCESS_END_STATUS_DESC = "����Ĭ�Ͻ���״̬";
	
	/** ����Ĭ�Ͻ���״̬��ʾ����*/
	public static final String PROCESS_END_STATUS_LABEL = "�ر�";
	
	/** ���̽ڵ�����-��ͨ�ڵ�*/
	public static final String PROCESS_NODE_TYPE_NORMAL = "0";
	
	/** ���̽ڵ�����-�ɷ��ɽڵ�*/
	public static final String PROCESS_NODE_TYPE_ASSIGN = "1";
	
	/** ���̽ڵ�����-���нڵ�*/
	public static final String PROCESS_NODE_TYPE_CONCURRENCY = "2";

	/** ���̽ڵ�����-��̬��֧�ڵ�*/
	public static final String PROCESS_NODE_TYPE_STATICBRANCH = "3";

	/** ���̽ڵ�����-��̬��֧�ڵ�*/
	public static final String PROCESS_NODE_TYPE_DYNAMICBRANCH = "4";

	/** ���̽ڵ�����-�ϲ��ڵ�*/
	public static final String PROCESS_NODE_TYPE_MERGE = "5";

	/** ���̽ڵ�����-�����̽ڵ�*/
	public static final String PROCESS_NODE_TYPE_CHILDPROCESS = "6";
	
	/** ���̽ڵ�����-�����̽ڵ� 0 ������������ ֣��� 2014.7.15*/
	public static final String PROCESS_SUB_TYPE0_CHILDPROCESS = "0";
	/** ���̽ڵ�����-�����̽ڵ� 1 ������������ ֣��� 2014.7.15*/
	public static final String PROCESS_SUB_TYPE1_CHILDPROCESS = "1";
	
	/** ��̬��֧����-��ɫ */
	public static final String PROCESS_BRANCHCOND_ROLE = "0";
	
	/** ��̬��֧����-��Ա */
	public static final String PROCESS_BRANCHCOND_USER = "1";
	
	//-----------Ig273-----------
	/** ԭ���������ָ���*/
	public static final String PROCESSPVARIABLE_COND_SPLIT = "|";
	
	/** �����������ָ���*/
	public static final String PROCESSPARTICIPANT_COND_SPLIT = "!";
	
	/** ����ָ��� */
	public static final String COND_COND_SPLIT = "#";
	
	/** ��������-�� */
	public static final String COND_TYPE_AND = "0";
	
	/** ��������-�� */
	public static final String COND_TYPE_OR = "1";
	
	/** ��������-ANY */
	public static final String COND_TYPE_ANY = "2";
	
	/** ��������-ȱʡ */
	public static final String COND_TYPE_DEFAULT = "3";
	
	/** ��������-ȱʡ��ɫ��ʶ */
	public static final String COND_TYPE_DEFAULT_ROLE = "AAA";
	
	
	
	//-----------ig222-----------
	public static final String PPD_ADD_ROLETYPE_MESSAGE = "��ӽ�ɫ����";
	
	public static final String PPD_ADD_PROCESSPARTICIPANT_MESSAGE = "��Ӳ�����";
	
	public static final String PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE = "ɾ��������";
	
	
	//-----------Comment Message-----------
	
	public static final String PROCESS_INITIAL_MESSAGE = "��������";
	public static final String COMMENT_OPENER_MESSAGE = "������";
	public static final String COMMENT_TERMINATE_MESSAGE = "��ֹ����";
	public static final String COMMENT_ASSIGNPERSON_MESSAGE = "�趨ִ����";
	public static final String COMMENT_DELETEPERSON_MESSAGE = "ɾ��ִ����";
	public static final String COMMENT_TRANSITION_MESSAGE = "����״̬ת��";

	
	/**
	 * �����߼����Ŷ���ת����������
	 * 
	 * @param cond String
	 */
	public static String convertLogicSineInfo(int cond) {
		int index=cond;
		String sign = null;
		switch (index) {
		case 1:
			sign = "����";
			break;
		case 2:
			sign = "������";
			break;
		case 3:
			sign = "����";
			break;
		case 4:
			sign = "С��";
			break;
		case 5:
			sign = "���ڵ���";
			break;
		case 6:
			sign = "С�ڵ���";
			break;
		default:
			sign = null;
			break;
		}
		return sign;
	}
	
	
	//-----------��־����-----------
	
	/**
	 * ��־����:ϵͳ��־
	 */
	public static final String RECORDLOG_TYPE_XTRZ = "0";
	
	/**
	 * ��־����:��˼�¼
	 */
	public static final String RECORDLOG_TYPE_SH = "1";
	
	/**
	 * ��־����:�����¼
	 */
	public static final String RECORDLOG_TYPE_CL = "2";
	
	/**
	 * ��־����:�ύ��¼
	 */
	public static final String RECORDLOG_TYPE_TJ = "3";
	
	/**
	 * ��־����:��ֹ��¼
	 */
	public static final String RECORDLOG_TYPE_ZZ = "4";
	
	/**
	 * ��־����:���¼�¼
	 */
	public static final String RECORDLOG_TYPE_GX = "5";
	
	/**
	 * �������̱�������
	 */
	public static final String PROCESSVAR_TREE_TYPE = "T";
	
	//=====================������־����====================================
	/**
	 * ��������־
	 */
	public static final String RECORDLOG_TYPE_CL_NAME = "��������־";
	
	/**
	 * ��������־
	 */
	public static final String RECORDLOG_TYPE_GX_NAME = "��������־";
	
	/**
	 * �������־
	 */
	public static final String RECORDLOG_TYPE_SH_NAME = "�������־";
	
	/**
	 * �ύ����־
	 */
	public static final String RECORDLOG_TYPE_TJ_NAME = "�ύ����־";
	
	/**
	 * ϵͳ����־
	 */
	public static final String RECORDLOG_TYPE_XTRZ_NAME = "ϵͳ����־";
	
	/**
	 * ��ֹ����־
	 */
	public static final String RECORDLOG_TYPE_ZZ_NAME = "��ֹ����־";
	
	//=====================��ɫ���ͳ���ֵ====================================
	/** ����̨ */
	public static final String ROLETYPE_SERVICE_DESK = "IGBP17";
	/** ����ʦ */
	public static final String ROLETYPE_ENGINEER = "IGBP15";
	
	//============================================================
	/** �Զ��幤�� */
	public static final String SELF_DEFINING_WORK_PRTYPE = "WD";
	
	/** ���ݱ������ */
	public static final String RLDESC_DATA = "�û���д���ݱ��";
	
	/** ���̹���Ա�޸��������� */
	public static final String RLADMIN_DATA = "���̹���Ա�޸�����";
	
	/** ��ʷ��¼����ֽ��� */
	public static final int RLDESC_MAX_BYTE = 512;
	
	/** ǰ���� */
	public static final String RLDESC_SYS = "ǰ�������ݱ��";
	
	//=====================�����¼���������====================================
	
	/** ǰ���� */
	public static final String PRETREATMENT = "1";
	
	/** ���� */
	public static final String AFTERTREATMENT = "2";
	
	/** ���߳� */
	public static final String THREADTREATMENT = "3";
	
	//=====================����JSP��������====================================
	
	/** ���� */
	public static final String CREATEJSP = "1";
	
	/** ���� */
	public static final String DEALJSP = "2";
	
	/** �鿴 */
	public static final String DETAILJSP = "3";
	
	/** �������Includeҳ*/
	public static final String RELEVANTPROCESSJSP = "4";
	
	/** ��ѯҳ*/
	public static final String SEARCHJSP = "5";
	
	//=====================����״̬super��ɫ��ʶ====================================
	
	/** �ǿɷ��ɽ�ɫ */
	public static final String UN_SUPER_ROLE = "0";
	
	/** �ɷ��ɽ�ɫ */
	public static final String SUPER_ROLE = "1";
	
	//=====================���̽ڵ�ģʽ====================================
	
	/** ��ͨģʽ */
	public static final String MODE_NORMAL = "1";
	
	/** OAģʽ */
	public static final String MODE_OA = "2";
	
	//=====================���̲��нڵ�����ʶ====================================
	
	/** ANY */
	public static final String TRANSITION_RULE_ANY = "ANY";
	
	//=====================�Ƿ������ɲ����߱�ʶ====================================
	
	/** ����Ҫ */
	public static final String NOT_NEED_ASSIGN = "0";
	
	/** ��Ҫ */
	public static final String NEED_ASSIGN = "1";
	
	//=====================�Ƿ�ֵ���˱�ʶ====================================
	
	/** ��ֵ���� */
	public static final String NOT_DUTYPERSON = "0";
	
	/** ֵ���� */
	public static final String DUTYPERSON = "1";
	
	//=====================�Ƿ��ɫ�����˱�ʶ====================================
	
	/** �ǽ�ɫ������ */
	public static final String NOT_ROLEMANAGER = "0";
	
	/** ��ɫ������ */
	public static final String ROLEMANAGER = "1";
	
	/** ��ʱ��ɫ�����ˣ�ֻ�����ύ�����ܸɱ�� */
	public static final String TEMP_ROLEMANAGER = "2";
	
	//=====================ֵ���˱���Ȩ�ύ��״̬��ʶ,PPSUBSTATUS====================================
	
	/** ��Ȩ�ύ */
	public static final String DUTYPERSON_NOACCESS = "0";
	
	/** ��Ȩ�ύ */
	public static final String DUTYPERSON_ACCESS = "1";
	
	//=====================�����Զ����ģʽ====================================
	
	/** ���̱�ģʽ������ */
	public static final String PROCESSINFODEF_MODE_PUBLIC = "0";
	
	/** ���̱�ģʽ��˽�� */
	public static final String PROCESSINFODEF_MODE_PRIVATE = "1";
	
	
	//=====================�Զ���������ض��������====================================
	
	/** IDǰ׺���� */
	public static final int ID_PREFIX_LENGTH = 5;
	
	/** ID�汾���� */
	public static final int ID_VERSION_LENGTH = 2;
	
	/** ID��׺�̶� */
	public static final int ID_SUFFIX_LENGTH = 3;
	
	//=====================��ɫ�ύȨ��====================================
	
	/** ͬ��ɫ�������ύԾǨ */
	public static final String UserCommitInRole_ALL = "1";
	
	/** ͬ��ɫ��һ���ύԾǨ */
	public static final String UserCommitInRole_ANY = "0";
	
	//=====================��ȷ�ϲ���====================================
	
	/** �� */
	public static final String SUBSTATUS_CONFIRM_NO = "0";
	
	/** �� */
	public static final String SUBSTATUS_CONFIRM_YES = "1";
	
	//=====================ȷ����״̬����====================================
	
	/** ��ȷ�� */
	public static final String PARTICIPANT_SUBSTATUS_CONFIRM = "1";
	
	//=====================���̲���֪ͨ������====================================
	
	/** ��ɫ������ */
	public static final String STRATEGY_NOTIFIER_TYPE_ROLEMANAGER = "0";
	
	/** ָ���� */
	public static final String STRATEGY_NOTIFIER_TYPE_USER = "1";
	
	//=====================���̲���֪ͨ��ʽ====================================
	
	/** ���� */
	public static final String STRATEGY_NOTICE_MODE_SMS = "1";
	
	/** �ʼ� */
	public static final String STRATEGY_NOTICE_MODE_EMAIL = "1";
	
	//=====================���̲���֪ͨ״̬0:״̬��ʱ֪ͨ 1:״̬��ʱ2:�����ϼ�3:�������峬ʱ====================================
	/** ״̬��ʱ֪ͨ */
	public static final String PROCESS_STATUS_SEND = "0";
	/** ״̬��ʱ */
	public static final String PROCESS_STATUS_OVERTIME = "1";
	/** �����ϼ� */
	public static final String PROCESS_STATUS_SEND_MANAGER = "2";
	/** �������峬ʱ */
	public static final String PROCESS_OVERTIME = "3";
	/** ����״̬��ʱ��¼��ʶ */ 
	public static final String PROCESS_STATUS_FLAG = "4";
	
	//=====================���̵Ǽ��Զ����ɲ˵�====================================
	/** ���̹���˵����� */
    public static final String ACTION_LABEL_MANAGE = "����";
    
    /** ���̷���˵����� */
    public static final String ACTION_LABEL_INIT = "����";
    
    /** ���̲�ѯ�˵����� */
    public static final String ACTION_LABEL_SEARCH = "��ѯ";
    
    /** ���̷���˵���� */
    public static final String ACTION_LABEL_INIT_NUM = "02";
    
    /** ���̲�ѯ�˵���� */
    public static final String ACTION_LABEL_SEARCH_NUM = "01";
    
    /** �Զ����ɵĶ����˵����� */
    public static final String ACTION_TYPE_2 = "M2";
    
    /** �Զ����ɵ������˵����� */
    public static final String ACTION_TYPE_3 = "M3";
    
    /** �Զ����ɲ˵��Ľ�ɫ��Ȩ */
    public static final String ACTION_ROLE_TYPE = "IGBP01";
    
    /** �Զ����ɲ˵���URL���� */
    public static final String ACTION_URL_TYPE = "0";
    
    /** �Զ��������Զ����ɲ˵���ͣ�ñ�ʶ */
    public static final int ACTION_STATUS_STOP = 1;
    
    /** �Զ������̰�ťУ��������ʶ */
    public static final String BUTTON_CHECKREQUIRED_YES = "1";
    
    /** �Զ������̰�ťУ�鴦���¼�Ǳ����ʶ */
    public static final String BUTTON_CHECKRECORD_NO = "0";
    
    /** �Զ������̰�ťУ�鴦���¼�����ʶ */
    public static final String BUTTON_CHECKRECORD_YES = "1";
    
	/** ��ѯ���й�����Ϣ */
	public static final String SEARCH_ALL_PROCESS ="1";
	
	/** ��ѯ���Լ��Ĺ���*/
	public static final String SEARCH_MY_PROCESS ="2";
	
	/** ��ѯ�͵�¼��ͬ�����Ĺ���*/
	public static final String SEARCH_ORG_PROCESS ="3";
	
	/** ��ѯ�͵�¼��ͬ��ɫ�Ĺ���*/
	public static final String SEARCH_ROLE_PROCESS ="4";
	
	/** ��ѯ���Լ�������Ĺ���*/
	public static final String SEARCH_MY_PROCESSED ="5";
	
	/** ��ѯ���Լ�δ������Ĺ���*/
	public static final String SEARCH_MY_UN_PROCESSED ="6";

	/** IG335�����̱�ʶ */
	public static final String MAIN_PROCESS_FLAG = "0100000000";

	/**���޹���֪ͨ����ʱpidid��3λĬ��ֵ*/
	public static final String PROCESS_UNRELFORM_IDEND = "000";
	/**���޹���֪ͨ����ʱpivalueĬ��ֵ*/
	public static final String PROCESS_UNRELFORM_VALUE = "N/A";

	/**Ŀǰ��������������ɵķ���Ϊ��*/
	/**֪ͨ����-״̬Ĭ�ϴ�����*/
	public static final String PROCESS_TACTICS_STATUS = "igReportTacticsBL";
	/**֪ͨ����-����Ĭ�ϴ�����*/
	public static final String PROCESS_TACTICS_WHOLE = "igWholeTacticsBL";
	/**ҵ�������Թ���Աroleid*/
	public static final Integer PLAN_ADMINISTRATOR_ROLEID = 2074;
	/**ҵ�������Թ���Աroleid���ڽ�ɫ����-Ӧ��ִ�в�*/
	public static final String PLAN_ADMINISTRATOR_ROLETYPE = "IGBP04";
	
	/**��������� �������� _����*/
	public static final String PD_ACTTYPE_INSERT = "insert";
	/**��������� �������� _ɾ��*/
	public static final String PD_ACTTYPE_DELETE = "delete";
	/**��������� �������� _�޸�*/
	public static final String PD_ACTTYPE_MODIFY = "modify";
}
